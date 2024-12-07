package fast.campus.netplix2.batch;

import fast.campus.netplix2.movie.FetchMovieUseCase;
import fast.campus.netplix2.movie.response.MoviePageableResponse;
import fast.campus.netplix2.movie.response.MovieResponse;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;

import java.util.LinkedList;
import java.util.List;

public class HttpPageItemReader extends AbstractItemCountingItemStreamItemReader<MovieResponse> {

    private int page; //페이지 정보
    private final List<MovieResponse> contents = new LinkedList<>();
    private final FetchMovieUseCase fetchMovieUseCase;

    public HttpPageItemReader(int page,FetchMovieUseCase fetchMovieUseCase){
        this.page = page;
        this.fetchMovieUseCase = fetchMovieUseCase;
    }

    @Override
    protected MovieResponse doRead() throws Exception{
        if (this.contents.isEmpty()) {
            readRow();
        }

        int size = contents.size();
        int index = size - 1;

        if (index < 0) {
            return null;
        }

        return contents.remove(contents.size() - 1);
    }

    @Override
    protected void doOpen() throws Exception {
        setName(HttpPageItemReader.class.getName());
    }

    @Override
    protected void doClose() throws Exception{

    }

    private void readRow() {
        MoviePageableResponse moviePageableResponse = fetchMovieUseCase.fetchFromClient(page);
        contents.addAll(moviePageableResponse.getTmdbMovies());
        page++;
    }
}
