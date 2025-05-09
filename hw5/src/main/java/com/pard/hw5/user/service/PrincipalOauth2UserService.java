package com.pard.hw5.user.service;

import com.pard.hw5.user.domain.User;
import com.pard.hw5.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepo userRepo;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException{
        log.info("UserRequest From Google : " + oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("Information From OAuth : " + oAuth2User.getAttributes());

        String email = (String) oAuth2User.getAttributes().get("email");
        String name = (String) oAuth2User.getAttributes().get("name");
        String socialId = (String) oAuth2User.getAttributes().get("sub");

        userRepo.findByEmail(email)
                .orElseGet(() -> userRepo.save(
                        User.builder()
                                .email(email)
                                .name(name)
                                .socialId(socialId)
                                .role(com.pard.hw5.user.domain.Role.USER)
                                .build()
                ));

        return oAuth2User;
    }
}
