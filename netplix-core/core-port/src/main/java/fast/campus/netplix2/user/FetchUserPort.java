package fast.campus.netplix2.user;

import java.util.Optional;

public interface FetchUserPort {
    Optional<UserPortReponse> findByEmail(String email);
}
