package fast.campus.netplix2.repository.sample;

import com.querydsl.jpa.impl.JPAQueryFactory;
import fast.campus.netplix2.entity.sample.QSampleEntity;
import fast.campus.netplix2.entity.sample.SampleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SampleCustomRepositoryImpl implements SampleCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SampleEntity> findAllByAbc() {
       return jpaQueryFactory.selectFrom(QSampleEntity.sampleEntity)
               .fetch();
    }
}
