package fast.campus.netplix2.audit;

import java.util.Optional;

public interface RequestedByProvider {
    Optional<String> getRequestedBy();
}
