package fast.campus.netplix2.sample;

import lombok.Getter;

@Getter
public class SamplePortResponse { //build gradle 에 추가 안하고 이렇게 추가하는 방법이 있다.ㄴ
    private final String name;

    public SamplePortResponse(String name) {
        this.name = name;
    }
}
