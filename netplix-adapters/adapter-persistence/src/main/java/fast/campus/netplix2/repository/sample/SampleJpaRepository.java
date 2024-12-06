package fast.campus.netplix2.repository.sample;

import fast.campus.netplix2.entity.sample.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleJpaRepository extends JpaRepository<SampleEntity,String>,SampleCustomRepository {

}
