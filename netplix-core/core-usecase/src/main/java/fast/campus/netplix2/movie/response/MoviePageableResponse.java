package fast.campus.netplix2.movie.response;

import lombok.Getter;

import java.util.List;

@Getter
public class MoviePageableResponse {
    private final List<MovieResponse> tmdbMovies;
    private final int page;
    private final boolean hasNext;

    public MoviePageableResponse(List<MovieResponse> tmdbMovies, int page, boolean hasNext) {
        this.tmdbMovies = tmdbMovies;
        this.page = page;
        this.hasNext = hasNext;
    }
}
