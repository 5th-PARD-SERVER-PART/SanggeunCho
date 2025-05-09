package com.pard.hw5.common.config;

import com.pard.hw5.user.service.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {

    private final PrincipalOauth2UserService principalOauth2UserService;

    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable); // JWT 쓸 때 들어감, 이미 있는 기능 비활성화

        http.addFilter(corsConfig.corsFilter());

        http.authorizeHttpRequests(au -> au.anyRequest().permitAll());

        http.oauth2Login(
                oauth -> oauth
                        .loginPage("/loginForm")
                        .defaultSuccessUrl("/login-success", true)
                        .userInfoEndpoint(
                                userInfo -> userInfo.userService(principalOauth2UserService) // 우리가 만들어 쓰는 함수
                        )
        );

        return http.build();
    }
}
