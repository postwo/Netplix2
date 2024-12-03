package fast.campus.netplix2.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TmdbMovieNowPlayingResponse {
    private TmdbDateResponse dates;
    private String page;

    @JsonProperty("total_pages")//전다받을때 json데이터에 total_pages에 있는 값을 가지고 backdropPath이변수
    private int totalPages;

    @JsonProperty("total_results")
    private String totalResults;

    private List<TmdbMovieNowPlaying> results;
}
