package fast.campus.netplix2.token;

import fast.campus.netplix2.user.response.UserResponse;

public interface FetchTokenUseCase {
    Boolean validationToken(String accessToken);

    String getTokenFromKakao(String code);

    UserResponse findUserByAccessToken(String accessToken);
}
