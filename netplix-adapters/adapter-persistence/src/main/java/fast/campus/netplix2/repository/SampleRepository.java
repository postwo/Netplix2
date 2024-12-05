package fast.campus.netplix2.repository;

import fast.campus.netplix2.entity.SampleEntity;
import fast.campus.netplix2.sample.SamplePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SampleRepository implements SamplePersistencePort {

    private final SampleJpaRepository sampleJpaRepository;

    @Override
    @Transactional
    public String getSampleName(String id) {
        Optional<SampleEntity> byId = sampleJpaRepository.findById(id);
        return byId.map(SampleEntity::getSampleName).orElseThrow();
    }
}
