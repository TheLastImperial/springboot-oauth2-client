package com.thelastimperial.oauth2_client.services.impl;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.thelastimperial.oauth2_client.entities.OidcUserEntity;
import com.thelastimperial.oauth2_client.repositories.OidcUserRepository;
import com.thelastimperial.oauth2_client.services.GeneralOidcUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GeneralOidcUserServiceImpl implements GeneralOidcUserService{
    private final OidcUserRepository oidcUserRepository;

    @Override
    public OidcUserEntity create(OidcUser userInfo) {
        Optional<OidcUserEntity> userExists = oidcUserRepository.findById(userInfo.getName());
        OidcUserEntity userSaved = new OidcUserEntity();

        if(userExists.isPresent()){
            userSaved = userExists.get();
        }else{
            userSaved = oidcUserRepository.save(
                oidcToOidcUser(userInfo.getAttributes())
            );
        }
        return userSaved;
    }

    public OidcUserEntity oidcToOidcUser(Map<String, Object> attributes){
        return OidcUserEntity.builder()
            .id(attributes.get("sub").toString())
            .name(attributes.getOrDefault("name", "").toString())
            .email(attributes.getOrDefault("email", "").toString())
            .picture(attributes.getOrDefault("picture", "").toString())
            .iss(attributes.getOrDefault("iss", "").toString())
            .build();
    }
}
