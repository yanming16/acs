package com.xiaoming.acs.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.xiaoming.acs.server.interceptor.AuthInterceptor;

/**
 * @author yanming03
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String[] SWAGGER_PATH_PATTERNS = {"/swagger-resources/**", "/webjars/**", "/v2/**",
            "/swagger-ui.html/**"};

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**").excludePathPatterns(SWAGGER_PATH_PATTERNS)
                .order(1);
    }

}
