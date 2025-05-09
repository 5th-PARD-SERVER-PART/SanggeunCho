package com.pard.hw5.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration // 설정파일 알려줌

public class CorsConfig { // Mapping 중 어떤 것만 받겠다고 필터링 해줌
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // 쿠키

        config.addAllowedOrigin("*"); // * -> 어디서 들어오던 일단 받을게

        config.addAllowedHeader("*");

        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/*", config);

        return new CorsFilter(source); // 정한 정책을 반환
    }
}
