package fast.campus.netplix2.token;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class NetPlixToken {
    private final String accessToken;
    private final String refreshToken;
    private final LocalDateTime accessTokenExpireAt;
    private final LocalDateTime refreshTokenExpireAt;

    public NetPlixToken (String accessToken,String refreshToken,LocalDateTime accessTokenExpireAt,LocalDateTime refreshTokenExpireAt){
        this.accessToken = accessToken;
        this.refreshToken =refreshToken;
        this.accessTokenExpireAt = accessTokenExpireAt;
        this.refreshTokenExpireAt = refreshTokenExpireAt;
    }
}
