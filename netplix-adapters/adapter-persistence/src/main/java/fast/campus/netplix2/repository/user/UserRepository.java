package fast.campus.netplix2.repository.user;

import fast.campus.netplix2.entity.user.UserEntity;
import fast.campus.netplix2.user.FetchUserPort;
import fast.campus.netplix2.user.UserPortReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements FetchUserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<UserPortReponse> findByEmail(String email) {
        Optional<UserEntity> byEmail = userJpaRepository.findByEmail(email);
        return byEmail.map(userEntity -> UserPortReponse.builder()
                .userId(userEntity.getUserId())
                .password(userEntity.getPassword())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .build());
    }
}
