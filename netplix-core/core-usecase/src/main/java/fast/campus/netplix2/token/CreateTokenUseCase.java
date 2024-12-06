package fast.campus.netplix2.token;

import fast.campus.netplix2.token.response.TokenResponse;

public interface CreateTokenUseCase {
    TokenResponse createNewToken(String userId);
}
