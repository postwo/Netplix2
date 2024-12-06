package fast.campus.netplix2.controller.user.requset;

import lombok.Getter;

@Getter
public class UserLoginRequest {
    private final String email;
    private final String password;

    public UserLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
