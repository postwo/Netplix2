package fast.campus.netplix2.user;

import fast.campus.netplix2.user.command.UserResponse;

public interface FetchUserUseCase {
    UserResponse findUserByEmail(String email);
}
