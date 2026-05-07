package com.thelastimperial.oauth2_client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelastimperial.oauth2_client.entities.OidcUserEntity;

@Repository
public interface OidcUserRepository extends JpaRepository<OidcUserEntity, String>{
    
}
