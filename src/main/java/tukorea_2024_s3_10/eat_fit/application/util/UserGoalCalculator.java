package tukorea_2024_s3_10.eat_fit.application.util;

import tukorea_2024_s3_10.eat_fit.domain.user.entity.UserIntakeGoal;
import tukorea_2024_s3_10.eat_fit.domain.user.entity.BodyProfile;
import tukorea_2024_s3_10.eat_fit.security.util.SecurityUtil;

public class UserGoalCalculator {

    public static UserIntakeGoal recommendUserGoal(BodyProfile bodyProfile) {

        Long currentUserId = SecurityUtil.getCurrentUserId();

        int goalKcal = (int) bodyProfile.getWeight() * 30;

        if(bodyProfile.getTargetWeight() > bodyProfile.getWeight()) {
            goalKcal = goalKcal * 11 / 10;
            return UserIntakeGoal.builder()
                    .userId(currentUserId)
                    .calorieGoal(goalKcal)
                    .sodiumGoal(2000)
                    .carbohydrateGoal((goalKcal * 0.15))
                    .sugarGoal(goalKcal * 0.015)
                    .fatGoal((goalKcal - (goalKcal * 0.6) - (bodyProfile.getWeight() * 4)) / 9)
                    .transFatGoal(goalKcal * 0.01 / 9)
                    .saturatedFatGoal(goalKcal * 0.08 / 9)
                    .cholesterolGoal(300)
                    .proteinGoal(bodyProfile.getWeight())
                    .build();
        }
        else if(bodyProfile.getTargetWeight() < bodyProfile.getWeight()) {
            goalKcal = goalKcal * 9 / 10;
            return UserIntakeGoal.builder()
                    .userId(currentUserId)
                    .calorieGoal(goalKcal)
                    .sodiumGoal(2000)
                    .carbohydrateGoal((goalKcal * 0.15))
                    .sugarGoal(goalKcal * 0.015)
                    .fatGoal((goalKcal - (goalKcal * 0.6) - (bodyProfile.getWeight() * 4)) / 9)
                    .transFatGoal(goalKcal * 0.01 / 9)
                    .saturatedFatGoal(goalKcal * 0.08 / 9)
                    .cholesterolGoal(300)
                    .proteinGoal(bodyProfile.getWeight())
                    .build();
        }
        else {
            return UserIntakeGoal.builder()
                    .userId(currentUserId)
                    .calorieGoal(goalKcal)
                    .sodiumGoal(2000)
                    .carbohydrateGoal((goalKcal * 0.15))
                    .sugarGoal(goalKcal * 0.015)
                    .fatGoal((goalKcal - (goalKcal * 0.6) - (bodyProfile.getWeight() * 4)) / 9)
                    .transFatGoal(goalKcal * 0.01 / 9)
                    .saturatedFatGoal(goalKcal * 0.08 / 9)
                    .cholesterolGoal(300)
                    .proteinGoal(bodyProfile.getWeight())
                    .build();
        }
    }
}


// 1.8 * 1.8 * 22 = 71.28
// 71.28 * 30 = 2138

// 1854 탄수 & 지방
// 탄수화물 320g = 1282Kcal 60%
// 지방 63g = 572 26%


// 1번 -> 탄수 = 2지방
// 탄수화물 309g = 1236Kcal 58%
// 단백질 71g = 284Kcal 14%
// 지방 69g = 618Kcal 28%

// 2번 -> 탄수 60% 고정
// 탄수화물 320g = 1282Kcal 60%
// 단백질 71g = 284Kcal 14%
// 지방 63g = 572 26%

// 3번 -> 4:4:2 (절대 아님)
// 탄수화물 213g = 855kcal
// 단백질 213g = 855kcal -> 죽음
// 지방 47g = 427kcal

// 4:2 < 진짜 몸에 가장 무리가 가지 않는 비율 그냥 가장 정석 식
// 5:2 < 활동을 한다는 가정하에 가장 베스트 비율

// 옥수수 맘모스빵 100g에 317kcal
// 탄수화물 44g 176kcal
// 단백질 5g 20 kcal
// 지방 14g 126kcal
// 총합 176 + 20 + 126 = 322kcal


// 단 2.5 : 1

// 1.68*1.68*22 = 62
// 62 * 30 = 1860kcal

// 60% 지방 22.5%

// 1번 -> 1탄수 = 2지방
// 탄수화물 269g = 1075kcal 58%
// 단백질 62g = 248kcal 13.3333%
// 지방 60g = 540kcal 28.6666%


// 단백질 10%

// 탄 2.5 : 1

// 1.62*1.62*21 = 55kg
// 55 * 30 = 1650kcal
// 탄수화물 247.5g = 990 kcal 60%
// 단백질 55g = 220kcal 13.3333%
// 지방 48.8g = 440kcal 26.6666%

// 1.8*1.8*21 = 68kg
// 2040kcal

// 목표 칼로리
// 단백질 = 몸무게1kg 당 1g
// 탄수화물 = 일일 칼로리의 15%
// 지방은 나머지
// 포화지방은 8% 언더 1650kcal 기준 포화지방 132kcal 이하로 권장 -> 14.666g 이하로 섭취
// 트랜스지방은 1% 언더
// 콜레스테롤은 300mg 언더
// 당은 탄수화물의 10% 이내
// 나트륨 WHO 기준 600mg이상 2000mg이하


// 1838kcal
// 탄수화물 275g = 1102kcal 60%
// 단백질 71g = 284kcal 15.4%
// 지방 50g = 457kcal 24.6 %

// 탄수화물 320g = 1282Kcal 60%
// 단백질 71g = 284Kcal 14%
// 지방 63g = 572 26%

//