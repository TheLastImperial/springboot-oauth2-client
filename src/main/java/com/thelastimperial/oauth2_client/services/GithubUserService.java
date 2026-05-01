package com.thelastimperial.oauth2_client.services;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.thelastimperial.oauth2_client.entities.GithubUserEntity;

public interface GithubUserService {
    public GithubUserEntity create(OAuth2User userInfo);
}
