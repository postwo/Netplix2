package fast.campus.netplix2.repository;

import fast.campus.netplix2.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleJpaRepsitory extends JpaRepository<SampleEntity,String> {
}
