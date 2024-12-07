package fast.campus.netplix2.user;

public interface KakaoUserport {

    UserPortReponse findUserFromKakao(String accessToken);
}
