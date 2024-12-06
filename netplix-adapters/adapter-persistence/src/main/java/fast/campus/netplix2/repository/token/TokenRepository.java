package fast.campus.netplix2.repository.token;

import fast.campus.netplix2.entity.token.TokenEntity;
import fast.campus.netplix2.token.InsertTokenPort;
import fast.campus.netplix2.token.SearchTokenPort;
import fast.campus.netplix2.token.TokenPortResponse;
import fast.campus.netplix2.token.UpdateTokenPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TokenRepository implements SearchTokenPort, InsertTokenPort, UpdateTokenPort {

    private final TokenJpaRepository tokenJpaRepository;

    @Override
    @Transactional
    public TokenPortResponse create(String userId, String accessToken, String refreshToken) {
        TokenEntity entity = TokenEntity.newTokenEntity(userId,accessToken,refreshToken);
        tokenJpaRepository.save(entity);
        return new TokenPortResponse(accessToken,refreshToken);
    }

    @Override
    @Transactional
    public TokenPortResponse findByUserId(String userId) {
        return tokenJpaRepository.findByUserId(userId)
                .map(result -> new TokenPortResponse(result.getAccessToken(),result.getRefreshToken()))
                .orElseThrow();// 사용자가 없을경우 orElseThrow()를 띄워준다.
    }

    @Override
    @Transactional
    public void updateToken(String userId, String accessToken, String refreshToken) {
        Optional<TokenEntity> byUserId = tokenJpaRepository.findByUserId(userId);
        if (byUserId.isEmpty()){
            throw new RuntimeException();
        }

        TokenEntity tokenEntity = byUserId.get();
        tokenEntity.updateToken(accessToken, refreshToken);
        tokenJpaRepository.save(tokenEntity);
    }
}
