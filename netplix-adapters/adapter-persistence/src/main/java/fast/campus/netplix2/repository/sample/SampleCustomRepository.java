package fast.campus.netplix2.repository.sample;

import fast.campus.netplix2.entity.sample.SampleEntity;

import java.util.List;

public interface SampleCustomRepository {
    List<SampleEntity> findAllByAbc();

}
