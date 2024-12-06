package fast.campus.netplix2.user;

import fast.campus.netplix2.exception.UserException;
import fast.campus.netplix2.user.command.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements FetchUserUseCase {

    private final FetchUserPort fetchUserPort;

    @Override
    public UserResponse findUserByEmail(String email) {
        Optional<UserPortReponse> byEmail = fetchUserPort.findByEmail(email);
        if (byEmail.isEmpty()){
            throw new UserException.UserDoseNotExistException();
        }

        UserPortReponse userPortReponse = byEmail.get();

        return UserResponse.builder()
                .userId(userPortReponse.getUserId())
                .email(userPortReponse.getEmail())
                .password(userPortReponse.getPassword())
                .phone(userPortReponse.getPhone())
                .role(userPortReponse.getRole())
                .username(userPortReponse.getUsername())
                .build();
    }
}
