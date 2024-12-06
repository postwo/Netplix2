package fast.campus.netplix2.controller.sample;

import fast.campus.netplix2.sample.SearchSampleUseCase;
import fast.campus.netplix2.sample.response.SampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SearchSampleUseCase searchSampleuseCase;

    @GetMapping("/api/v1/sample")
    public SampleResponse getSample(){
        return searchSampleuseCase.getSample();
    }
}
