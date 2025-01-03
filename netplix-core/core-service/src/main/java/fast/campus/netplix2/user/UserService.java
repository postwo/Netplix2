package fast.campus.netplix2.user;

import fast.campus.netplix2.exception.UserException;
import fast.campus.netplix2.user.command.UserRegistrationCommand;
import fast.campus.netplix2.user.response.UserRegistrationResponse;
import fast.campus.netplix2.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements FetchUserUseCase, RegisterUserUseCase {

    //사용자 조회 포트이다.
    private final FetchUserPort fetchUserPort;

    //사용자 데이터 저장 포트
    private final InsertUserPort insertUserPort;

    private final KakaoUserport kakaoUserport;

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

    @Override
    public UserResponse findByProviderId(String providerId) {
       return fetchUserPort.findByproviderid(providerId)
               .map(it -> UserResponse.builder()
                       .providerId(it.getProviderId())
                       .provider(it.getProvider())
                       .username(it.getUsername())
                       .build())
               .orElse(null);
    }

    @Override
    public UserResponse findKakaoUser(String accessToken) {
        UserPortReponse userFromKakao = kakaoUserport.findUserFromKakao(accessToken);
        return UserResponse.builder()
                .provider(userFromKakao.getProvider())
                .providerId(userFromKakao.getProviderId())
                .username(userFromKakao.getUsername())
                .build();
    }

    @Override
    public UserRegistrationResponse register(UserRegistrationCommand command) {
        String email = command.getEmail();
        //사용자 조회
        Optional<UserPortReponse> byEmail = fetchUserPort.findByEmail(email);

        //만약 있으면?
        if (byEmail.isPresent()){
            // 예외를 던지기
            throw new UserException.UserAlreadyExistException();//이미 존재한다면
        }

        // 회원가입 시도
        UserPortReponse response = insertUserPort.create(CreateUser.builder()
                        .username(command.getUsername())
                        .encryptedPassword(command.getEncryptedPassword())
                        .email(command.getEmail())
                        .phone(command.getPhone())
                        .build()
                );
        //UserRegistrationResponse를 리턴
        return new UserRegistrationResponse(response.getUsername(),response.getEmail(), response.getPhone());
    }

    @Override
    public UserRegistrationResponse registerSocialUser(String username, String provider, String providerId) {
        Optional<UserPortReponse> byproviderid = fetchUserPort.findByproviderid(providerId);
        if (byproviderid.isPresent()){
            return null;
        }

        UserPortReponse socialUser = insertUserPort.createSocialUser(username, provider, providerId);
        return new UserRegistrationResponse(socialUser.getUsername(),null,null);
    }
}
