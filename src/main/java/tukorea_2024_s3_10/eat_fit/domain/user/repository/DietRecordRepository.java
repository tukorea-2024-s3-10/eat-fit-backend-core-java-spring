package tukorea_2024_s3_10.eat_fit.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tukorea_2024_s3_10.eat_fit.domain.user.entity.DietRecord;

public interface DietRecordRepository{
    DietRecord save(DietRecord dietRecord);
}