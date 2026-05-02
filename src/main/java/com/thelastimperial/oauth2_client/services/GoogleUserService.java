package com.thelastimperial.oauth2_client.services;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import com.thelastimperial.oauth2_client.entities.GoogleUserEntity;

public interface GoogleUserService {
    public GoogleUserEntity create(OidcUser userInfo);
}
