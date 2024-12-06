package fast.campus.netplix2.controller.movie;

import fast.campus.netplix2.controller.NetplixApiResponse;
import fast.campus.netplix2.movie.FetchMovieUseCase;
import fast.campus.netplix2.movie.response.MoviePageableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final FetchMovieUseCase fetchMovieUseCase;

    @GetMapping("/api/v1/movie/client/{page}")
    public NetplixApiResponse<MoviePageableResponse> fetchMoviePageables(@PathVariable int page){
        MoviePageableResponse pageableMovieResponse = fetchMovieUseCase.fetchFromClient(page); //TmdbMovielisthttpClient 에가서 request걸고 디버그 찍어보기
        return NetplixApiResponse.ok(pageableMovieResponse);
    }
}
