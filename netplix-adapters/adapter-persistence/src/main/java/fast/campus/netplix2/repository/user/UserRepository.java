package fast.campus.netplix2.repository.user;

import fast.campus.netplix2.entity.user.SocialUserEntity;
import fast.campus.netplix2.entity.user.UserEntity;
import fast.campus.netplix2.repository.user.social.SocialUserJpaRepository;
import fast.campus.netplix2.user.CreateUser;
import fast.campus.netplix2.user.FetchUserPort;
import fast.campus.netplix2.user.InsertUserPort;
import fast.campus.netplix2.user.UserPortReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements FetchUserPort, InsertUserPort {

    private final UserJpaRepository userJpaRepository;
    private final SocialUserJpaRepository socialUserJpaRepository;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public Optional<UserPortReponse> findByproviderid(String providerId) {
        Optional<SocialUserEntity> userEntityOptional = socialUserJpaRepository.findByProviderId(providerId);
        if (userEntityOptional.isEmpty()) {
            return Optional.empty();
        }

        SocialUserEntity socialUserEntity = userEntityOptional.get();

        return Optional.of(UserPortReponse.builder()
                .provider(socialUserEntity.getProvider())
                .providerId(socialUserEntity.getProviderId())
                .username(socialUserEntity.getUsername())
                .build());
    }

    @Override
    @Transactional
    public UserPortReponse create(CreateUser user) {
        UserEntity userEntity = new UserEntity(
                user.getUsername(), user.getEncryptedPassword(),user.getEmail(),user.getPhone());
        UserEntity save = userJpaRepository.save(userEntity);
        return UserPortReponse.builder()
                .userId(save.getUserId())
                .username(save.getUsername())
                .password(save.getPassword())
                .email(save.getEmail())
                .phone(save.getPhone())
                .build();
    }

    @Override
    @Transactional
    public UserPortReponse createSocialUser(String username, String provider, String providerId) {
        SocialUserEntity socialUserEntity = new SocialUserEntity(username,provider,providerId);
        socialUserJpaRepository.save(socialUserEntity);
        return UserPortReponse.builder()
                .provider(socialUserEntity.getProvider())
                .providerId(socialUserEntity.getProviderId())
                .username(socialUserEntity.getUsername())
                .build();
    }
}
