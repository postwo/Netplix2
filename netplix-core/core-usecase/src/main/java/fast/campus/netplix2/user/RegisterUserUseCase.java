package fast.campus.netplix2.user;

import fast.campus.netplix2.user.command.UserRegistrationCommand;
import fast.campus.netplix2.user.response.UserRegistrationResponse;

public interface RegisterUserUseCase {
    UserRegistrationResponse register(UserRegistrationCommand command);
    UserRegistrationResponse registerSocialUser(String username, String provider,String providerId);
}
