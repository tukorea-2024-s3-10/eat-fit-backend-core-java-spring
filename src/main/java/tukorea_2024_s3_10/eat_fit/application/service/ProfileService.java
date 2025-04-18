package tukorea_2024_s3_10.eat_fit.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tukorea_2024_s3_10.eat_fit.application.util.UserGoalCalculator;
import tukorea_2024_s3_10.eat_fit.domain.user.entity.*;
import tukorea_2024_s3_10.eat_fit.domain.user.repository.BodyProfileRepository;
import tukorea_2024_s3_10.eat_fit.domain.user.repository.UserDiseaseRepository;
import tukorea_2024_s3_10.eat_fit.domain.user.repository.UserIntakeGoalRepository;
import tukorea_2024_s3_10.eat_fit.domain.user.repository.UserRepository;
import tukorea_2024_s3_10.eat_fit.infrastructure.security.SecurityUtil;
import tukorea_2024_s3_10.eat_fit.presentation.user.dto.ProfileSetupRequest;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserRepository userRepository;
    private final BodyProfileRepository bodyProfileRepository;
    private final UserDiseaseRepository userDiseaseRepository;
    private final UserIntakeGoalRepository userIntakeGoalRepository;

    @Transactional
    public void setupProfile(ProfileSetupRequest profileSetupRequest) {

        // 현재 로그인 중인 사용자의 식별자를 불러옴
        Long currentUserId = SecurityUtil.getCurrentUserId();

        User user = userRepository.findById(currentUserId).orElseThrow(NoSuchElementException::new);

        user.updateNickname(profileSetupRequest.getNickname());
        user.updateRole(Role.ROLE_USER);

        BodyProfile bodyProfile = BodyProfile.builder()
                .userId(user.getId())
                .gender(profileSetupRequest.getGender())
                .age(profileSetupRequest.getAge())
                .height(profileSetupRequest.getHeight())
                .weight(profileSetupRequest.getWeight())
                .goalType(profileSetupRequest.getGoalType())
                .build();

        for(String disease : profileSetupRequest.getDiseases()){
            UserDisease userDisease = UserDisease.builder()
                    .userId(user.getId())
                    .disease(disease)
                    .build();
            userDiseaseRepository.save(userDisease);
        }

        UserIntakeGoal userIntakeGoal = UserGoalCalculator.recommendUserGoal(bodyProfile);

        userRepository.save(user);
        bodyProfileRepository.save(bodyProfile);
        userIntakeGoalRepository.save(userIntakeGoal);

        /**
         * 1. 사용자 프로필 정보 저장
         *  이미지는 S3 저장 후 URL로 저장 (후순위)
         * 2. 사용자 신체 정보 저장
         * 3. 입력 정보를 바탕으로 사용자 맞춤 목표 설정
         */
    }
}
