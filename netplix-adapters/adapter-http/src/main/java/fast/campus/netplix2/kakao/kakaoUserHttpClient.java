package fast.campus.netplix2.kakao;

import fast.campus.netplix2.user.KakaoUserport;
import fast.campus.netplix2.user.UserPortReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class kakaoUserHttpClient implements KakaoUserport {

    private final String KAKAO_USERINFO_API_URL = "https://kapi.kakao.com/v2/user/me";

    @Override
    public UserPortReponse findUserFromKakao(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);  // 액세스 토큰을 Authorization 헤더에 추가

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map>response = restTemplate.exchange(
                 KAKAO_USERINFO_API_URL,
                 HttpMethod.GET,
                 entity,
                 Map.class
        );

        Long providerId = (Long) response.getBody().get("id");

        Map properties = (Map) response.getBody().get("properties");
        String nickname = (String) properties.get("nickname");

        return UserPortReponse.builder()
                .username(nickname)
                .providerId(providerId.toString())
                .provider("kakao")
                .build();
    }
}
