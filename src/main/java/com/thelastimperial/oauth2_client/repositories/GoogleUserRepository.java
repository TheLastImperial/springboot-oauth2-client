package com.thelastimperial.oauth2_client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelastimperial.oauth2_client.entities.GoogleUserEntity;

@Repository
public interface GoogleUserRepository extends JpaRepository<GoogleUserEntity, String>{
}
