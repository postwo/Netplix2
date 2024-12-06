package fast.campus.netplix2.repository.token;

import fast.campus.netplix2.entity.token.TokenEntity;

import java.util.Optional;

public interface TokenCustomRepository {
    Optional<TokenEntity> findByUserId(String userid);
}
