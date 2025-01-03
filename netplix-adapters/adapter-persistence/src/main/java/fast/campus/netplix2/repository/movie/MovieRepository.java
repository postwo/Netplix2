//package fast.campus.netplix2.repository.movie;
//
//import fast.campus.netplix2.entity.movie.MovieEntity;
//import fast.campus.netplix2.movie.NetplixMovie;
//import fast.campus.netplix2.movie.PersistenceMoviePort;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class MovieRepository implements PersistenceMoviePort {
//
//    private final MovieJpaRepository movieJpaRepository;
//
//    @Override
//    @Transactional
//    public List<NetplixMovie> fetchBy(int page, int size) {
//        return movieJpaRepository.search(PageRequest.of(page, size)).stream().map(MovieEntity::toDomain).toList();
//    }
//
//    @Override
//    public NetplixMovie findBy(String movieName) {
//        return movieJpaRepository.findByMovieName(movieName)
//                .map(MovieEntity::toDomain)
//                .orElseThrow();
//    }
//
//    @Override
//    @Transactional
//    public String insert(NetplixMovie netplixMovie) {
//        MovieEntity entity = MovieEntity.toEntity(netplixMovie);
//        Optional<MovieEntity> byMovieName = movieJpaRepository.findByMovieName(netplixMovie.getMovieName());
//
//        if (byMovieName.isEmpty()) {
//            log.info("신규 영화 추가={}", netplixMovie.getMovieName());
//            movieJpaRepository.save(entity);
//            return entity.getMovieId();
//        }
//
//        return null;
//    }
//}
