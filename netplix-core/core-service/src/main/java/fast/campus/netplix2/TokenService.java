package fast.campus.netplix2;

import fast.campus.netplix2.token.CreateTokenUseCase;
import fast.campus.netplix2.token.FetchTokenUseCase;
import fast.campus.netplix2.token.UpdateTokenUseCase;
import fast.campus.netplix2.token.response.TokenResponse;
import fast.campus.netplix2.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService implements FetchTokenUseCase, CreateTokenUseCase, UpdateTokenUseCase {

    @Override
    public TokenResponse createNewToken(String userId) {
        return null;
    }

    @Override
    public Boolean validationToken(String accessToken) {
        return null;
    }

    @Override
    public String getTokenFromKakao(String code) {
        return null;
    }

    @Override
    public UserResponse findUserByAccessToken(String accessToken) {
        return null;
    }
}
