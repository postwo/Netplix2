package fast.campus.netplix2.controller.user.requset;

import lombok.Getter;

@Getter
public class UserRegisterRequest { // 프론트에서 받아올 데이터
    private final String username;
    private final String password;
    private final String email;
    private final String phone;


    public UserRegisterRequest(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
