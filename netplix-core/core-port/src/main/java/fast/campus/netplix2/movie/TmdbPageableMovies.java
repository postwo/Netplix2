package fast.campus.netplix2.movie;

import lombok.Getter;

import java.util.List;

@Getter
public class TmdbPageableMovies {

    private final List<TmdbMovie> tmdbMovies;
    private final int page;
    private final boolean hasNext;

    public TmdbPageableMovies(List<TmdbMovie> tmdbMovies, int page, boolean hasNext) {
        this.tmdbMovies = tmdbMovies;
        this.page = page;
        this.hasNext = hasNext;
    }
}