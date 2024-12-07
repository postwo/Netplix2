package fast.campus.netplix2.movie;

import fast.campus.netplix2.movie.response.MovieResponse;

import java.util.List;

public interface InsertMovieUseCase {
    void insert(List<MovieResponse> items);
}
