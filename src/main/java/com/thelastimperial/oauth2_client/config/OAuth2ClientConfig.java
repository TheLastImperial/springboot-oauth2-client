package com.thelastimperial.oauth2_client.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.client.JdbcOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;

@Configuration
public class OAuth2ClientConfig {
    @Bean
    public GrantedAuthoritiesMapper grantedAuthoritiesMapper(){
        return (authorities)->{
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            authorities.forEach(authority -> {
                if(OAuth2UserAuthority.class.isInstance(authority)){
		            // OAuth2UserAuthority oauth2UserAuthority = (OAuth2UserAuthority)authority;
					// Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();

                    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                } else if (OidcUserAuthority.class.isInstance(authority)) {
					// OidcUserAuthority oidcUserAuthority = (OidcUserAuthority)authority;
					// OidcIdToken idToken = oidcUserAuthority.getIdToken();
					// OidcUserInfo userInfo = oidcUserAuthority.getUserInfo();

                    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				}
            });
            return mappedAuthorities;
        };
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService(
            JdbcOperations jdbcOperations,
            ClientRegistrationRepository clientRegistrationRepository) {
        return new JdbcOAuth2AuthorizedClientService(jdbcOperations, clientRegistrationRepository);
    }
}
