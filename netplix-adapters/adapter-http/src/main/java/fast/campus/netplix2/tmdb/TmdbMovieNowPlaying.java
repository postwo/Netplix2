package fast.campus.netplix2.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TmdbMovieNowPlaying {

    private Boolean adult;

    @JsonProperty("backdrop_path")//전다받을때 json데이터에 backdrop_path에 있는 값을 가지고 backdropPath이변수 매핑을 해준다.
    private String backdropPath;

    @JsonProperty("genre_ids")
    private List<String> genreIds;

    private Integer id;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_title")
    private String originalTitle;

    private String overview;

    private String popularity;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("release_date")
    private String releaseDate;

    private String title;

    private String video;

    @JsonProperty("vote_average")
    private String voteAverage;

    @JsonProperty("vote_count")
    private String voteCount;

}
