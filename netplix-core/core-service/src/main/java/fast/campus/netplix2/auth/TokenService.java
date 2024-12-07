package fast.campus.netplix2.auth;

import fast.campus.netplix2.token.*;
import fast.campus.netplix2.token.response.TokenResponse;
import fast.campus.netplix2.user.FetchUserUseCase;
import fast.campus.netplix2.user.response.UserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService implements FetchTokenUseCase, CreateTokenUseCase, UpdateTokenUseCase {

    @Value("${jwt.secret}")
    private String secretKey;

    private final SearchTokenPort searchTokenPort;
    private final InsertTokenPort insertTokenPort;
    private final UpdateTokenPort updateTokenPort;
    private final FetchUserUseCase fetchUserUseCase;
    private final KakaoTokenPort kakaoTokenPort;


    @Override
    public TokenResponse createNewToken(String userId) {
        String accessToken = getToken(userId,Duration.ofHours(3));
        String refreshToken = getToken(userId,Duration.ofHours(24));

        TokenPortResponse tokenPortResponse = insertTokenPort.create(userId,accessToken,refreshToken);

        return TokenResponse.builder()
                .refreshToken(tokenPortResponse.getRefreshToken())
                .accessToken(tokenPortResponse.getAccessToken())
                .build();
    }

    // 성공 실패 정도만 알기 위해서 사용
    @Override
    public Boolean validateToken(String accessToken) {
        Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(accessToken);

        return true;
    }

    @Override
    public String getTokenFromKakao(String code) {
        return kakaoTokenPort.getAccessTokenByCode(code);
    }

    @Override
    public UserResponse findUserByAccessToken(String accessToken) {
        Claims claims = parseClaims(accessToken);

        Object userId = claims.get("userId");

        if (ObjectUtils.isEmpty(userId)) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        return fetchUserUseCase.findByProviderId(userId.toString());
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }


    private String getToken(String userid, Duration expireAt){
        Date now = new Date();
        Instant instant = now.toInstant();

        return Jwts.builder()
                .claim("userId",userid)
                .issuedAt(now)
                .expiration(Date.from(instant.plus(expireAt)))
                .signWith(getSigningKey())
                .compact();
    }


    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String upsertToken(String providerId) {
        TokenPortResponse byUserId = searchTokenPort.findByUserId(providerId);
        String accessToken = getToken(providerId,Duration.ofHours(3));
        String refreshToken = getToken(providerId,Duration.ofHours(24));

        if (byUserId == null){
            // create
            insertTokenPort.create(providerId,accessToken,refreshToken);
        }else {
            //update
            updateTokenPort.updateToken(providerId,accessToken,refreshToken);
        }

        return accessToken;
    }
}
