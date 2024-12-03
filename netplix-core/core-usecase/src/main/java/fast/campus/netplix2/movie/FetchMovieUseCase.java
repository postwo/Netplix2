package fast.campus.netplix2.movie;

import fast.campus.netplix2.movie.response.MoviePageableResponse;

public interface FetchMovieUseCase  {
  MoviePageableResponse fetchFromClient(int page);
}
