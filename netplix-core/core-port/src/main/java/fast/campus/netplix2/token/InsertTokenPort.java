package fast.campus.netplix2.token;

public interface InsertTokenPort {
    TokenPortResponse create(String userId,String accessToken, String refreshToken);
}
