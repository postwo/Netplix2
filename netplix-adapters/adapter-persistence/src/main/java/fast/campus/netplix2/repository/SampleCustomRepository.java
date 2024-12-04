package fast.campus.netplix2.repository;

import fast.campus.netplix2.entity.SampleEntity;

import java.util.List;

public interface SampleCustomRepository {
    List<SampleEntity> findAll();
}
