package fast.campus.netplix2.controller.user;

import fast.campus.netplix2.controller.NetplixApiResponse;
import fast.campus.netplix2.controller.user.requset.UserRegisterRequest;
import fast.campus.netplix2.user.RegisterUserUseCase;
import fast.campus.netplix2.user.command.UserRegistrationCommand;
import fast.campus.netplix2.user.response.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

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
}
