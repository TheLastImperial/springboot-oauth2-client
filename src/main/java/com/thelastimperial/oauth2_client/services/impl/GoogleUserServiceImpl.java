package com.thelastimperial.oauth2_client.services.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.thelastimperial.oauth2_client.entities.GoogleUserEntity;
import com.thelastimperial.oauth2_client.repositories.GoogleUserRepository;
import com.thelastimperial.oauth2_client.services.GoogleUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GoogleUserServiceImpl implements GoogleUserService {
    private final GoogleUserRepository googleUserRepository;

    @Override
    public GoogleUserEntity create(OidcUser userInfo) {
        Optional<GoogleUserEntity> userExists = googleUserRepository.findById(userInfo.getName());
        GoogleUserEntity userSaved = new GoogleUserEntity();

        if(userExists.isPresent()){
            userSaved = userExists.get();
        }else{
            userSaved = googleUserRepository.save(
                oidcToGoogleUser(userInfo.getAttributes())
            );
        }
        return userSaved;
    }

    public GoogleUserEntity oidcToGoogleUser(Map<String, Object> attributes){
        return GoogleUserEntity.builder()
            .id(attributes.get("sub").toString())
            .name(attributes.get("name").toString())
            .email(attributes.get("email").toString())
            .picture(attributes.get("picture").toString())
            .iss(attributes.get("iss").toString())
            .build();
    }
    
}
