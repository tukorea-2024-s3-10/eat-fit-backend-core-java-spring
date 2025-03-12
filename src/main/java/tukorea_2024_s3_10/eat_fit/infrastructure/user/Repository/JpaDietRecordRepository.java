package tukorea_2024_s3_10.eat_fit.infrastructure.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tukorea_2024_s3_10.eat_fit.domain.user.DietRecord;

import java.time.LocalDate;
import java.util.List;

public interface JpaDietRecordRepository extends JpaRepository<DietRecord, Long> {
    List<DietRecord> findByUserIdAndDate(long userId, LocalDate date);
}
