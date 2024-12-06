package fast.campus.netplix2.repository.token;

import fast.campus.netplix2.token.InsertTokenPort;
import fast.campus.netplix2.token.SearchTokenProt;
import fast.campus.netplix2.token.TokenPortResponse;
import fast.campus.netplix2.token.UpdateTokenPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class TokenRepository implements SearchTokenProt, InsertTokenPort, UpdateTokenPort {

    private final TokenJpaRepository tokenJpaRepository;

    @Override
    @Transactional
    public TokenPortResponse create(String userId, String accessToken, String refreshToken) {
        return null;
    }

    @Override
    @Transactional
    public TokenPortResponse findByUserId(String userId) {
        return null;
    }

    @Override
    @Transactional
    public void updateToken(String userId, String accessToken, String refreshToken) {

    }
}
