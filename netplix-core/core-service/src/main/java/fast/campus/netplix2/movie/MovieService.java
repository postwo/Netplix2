package fast.campus.netplix2.movie;

import fast.campus.netplix2.movie.response.MoviePageableResponse;
import fast.campus.netplix2.movie.response.MovieResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService implements FetchMovieUseCase, InsertMovieUseCase {

    private final TmdbMoviePort tmdbMoviePort;

    @Override
    public MoviePageableResponse fetchFromClient(int page) {
        TmdbPageableMovies tmdbPageableMovies = tmdbMoviePort.fetchPageable(page);
        return new MoviePageableResponse(
                tmdbPageableMovies.getTmdbMovies().stream()
                        .map(movie -> new MovieResponse(
                                movie.getMovieName(),
                                movie.getIsAdult(),
                                movie.getGenre(),
                                movie.getOverview(),
                                movie.getReleaseAt()
                        ))
                        .collect(Collectors.toList()),
                tmdbPageableMovies.getPage(),
                tmdbPageableMovies.isHasNext()
        );
    }

    @Override
    public void insert(List<MovieResponse> items) {
        log.info("[{}] {}",items.size(),items.get(0).getMovieName());
    }
}
