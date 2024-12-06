package fast.campus.netplix2.token;

public interface SearchTokenPort {
    TokenPortResponse findByUserId(String userId);
}
