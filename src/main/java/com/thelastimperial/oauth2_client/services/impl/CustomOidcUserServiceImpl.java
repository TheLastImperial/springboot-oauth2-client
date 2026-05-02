package com.thelastimperial.oauth2_client.services.impl;

import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.thelastimperial.oauth2_client.services.GoogleUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomOidcUserServiceImpl extends OidcUserService {
    private final GoogleUserService googleUserService;

    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            googleUserService.create(oidcUser);
        }
        return oidcUser;
    }
}
