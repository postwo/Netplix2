package fast.campus.netplix2.user;

public interface InsertUserPort {
    UserPortReponse create(CreateUser user);
    UserPortReponse createSocialUser(String username,String provider, String providerId);
}
