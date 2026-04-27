package com.thelastimperial.oauth2_client.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    Log log = LogFactory.getLog(SecurityConfig.class);

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/user").hasRole("USER")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .oauth2Login(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .build();
    }

    @Bean
    public GrantedAuthoritiesMapper grantedAuthoritiesMapper(){
        return (authorities)->{
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            authorities.forEach(authority -> {
                if(OAuth2UserAuthority.class.isInstance(authority)){
		            // OAuth2UserAuthority oauth2UserAuthority = (OAuth2UserAuthority)authority;
					// Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();

                    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_GITHUB"));
                } else if (OidcUserAuthority.class.isInstance(authority)) {
					// OidcUserAuthority oidcUserAuthority = (OidcUserAuthority)authority;
					// OidcIdToken idToken = oidcUserAuthority.getIdToken();
					// OidcUserInfo userInfo = oidcUserAuthority.getUserInfo();

                    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_GITHUB"));
				}
            });
            return mappedAuthorities;
        };
    }
}
