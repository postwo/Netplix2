package fast.campus.netplix2.user;

import fast.campus.netplix2.user.response.UserResponse;

public interface FetchUserUseCase {
    UserResponse findUserByEmail(String email);

    UserResponse findByProviderId(String providerId);

    UserResponse findKakaoUser(String accessToken);
}
