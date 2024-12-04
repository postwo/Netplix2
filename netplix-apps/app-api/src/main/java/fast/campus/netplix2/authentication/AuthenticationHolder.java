package fast.campus.netplix2.authentication;

import java.util.Optional;

public interface AuthenticationHolder {
    Optional<Authentication> getAuthentication();
    void setAuthentication(Authentication authentication);
}
