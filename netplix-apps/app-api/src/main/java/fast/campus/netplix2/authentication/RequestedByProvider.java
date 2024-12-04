package fast.campus.netplix2.authentication;

import java.util.Optional;

public interface RequestedByProvider {
    Optional<String> getRequestedBy();
}