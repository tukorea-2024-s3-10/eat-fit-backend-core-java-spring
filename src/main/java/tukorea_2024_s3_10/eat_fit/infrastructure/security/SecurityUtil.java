package tukorea_2024_s3_10.eat_fit.infrastructure.security;

import org.springframework.security.core.context.SecurityContextHolder;
import tukorea_2024_s3_10.eat_fit.infrastructure.security.dto.CustomOAuth2User;

public class SecurityUtil {
    public static Long getCurrentUserId() {
        return ((CustomOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
    }
}
