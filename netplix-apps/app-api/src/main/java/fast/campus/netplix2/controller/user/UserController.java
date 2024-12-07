package fast.campus.netplix2.controller.user;

import fast.campus.netplix2.controller.NetplixApiResponse;
import fast.campus.netplix2.controller.user.requset.UserLoginRequest;
import fast.campus.netplix2.controller.user.requset.UserRegisterRequest;
import fast.campus.netplix2.security.NetplixAuthUser;
import fast.campus.netplix2.token.FetchTokenUseCase;
import fast.campus.netplix2.user.FetchUserUseCase;
import fast.campus.netplix2.user.RegisterUserUseCase;
import fast.campus.netplix2.user.command.UserRegistrationCommand;
import fast.campus.netplix2.user.response.UserRegistrationResponse;
import fast.campus.netplix2.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;//인증 용도
    private final FetchTokenUseCase fetchTokenUseCase;
    private final FetchUserUseCase fetchUserUseCase;

    @PostMapping("/register")
    public NetplixApiResponse<UserRegistrationResponse> register(
            @RequestBody UserRegisterRequest request
    ) {
       UserRegistrationResponse register = registerUserUseCase.register(UserRegistrationCommand.builder()
                .username(request.getUsername())
                .encryptedPassword(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build());

        return NetplixApiResponse.ok(register);
    }

    @PostMapping("/login")
    public NetplixApiResponse<String> login(@RequestBody UserLoginRequest request){
        String email = request.getEmail();
        String password = request.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email,password);
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(token);

        NetplixAuthUser principal = (NetplixAuthUser) authenticate.getPrincipal();

        return NetplixApiResponse.ok("access-token");
    }

    @PostMapping("/callback")
    public NetplixApiResponse<String> kakaoCallback(@RequestBody Map<String,String> request){
        String code =request.get("code");

        String accessTokenFromKakao = fetchTokenUseCase.getTokenFromKakao(code);
        UserResponse kakaouser = fetchUserUseCase.findKakaoUser(accessTokenFromKakao);

        return NetplixApiResponse.ok(null);
    }
}
