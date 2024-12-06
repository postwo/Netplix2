package fast.campus.netplix2.repository.token;

import fast.campus.netplix2.entity.token.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenJpaRepository extends JpaRepository<TokenEntity, String>,TokenCustomRepository {
}
