package com.thelastimperial.oauth2_client.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.thelastimperial.oauth2_client.entities.GithubUserEntity;
import com.thelastimperial.oauth2_client.repositories.GithubUserRepository;
import com.thelastimperial.oauth2_client.services.GithubUserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class GithubUserServiceImpl implements GithubUserService{
    private final GithubUserRepository githubUserRepository;

    @Override
    public GithubUserEntity create(OAuth2User userInfo) {
        Long id = Long.parseLong(userInfo.getName());
        GithubUserEntity userToSave = attrToGithubUserEntity(id, userInfo.getAttributes());
        Optional<GithubUserEntity> existUser = githubUserRepository.findById(userToSave.getId());
        GithubUserEntity userSaved = new GithubUserEntity();

        if(existUser.isPresent()){
            userSaved = existUser.get();
        }else{
            userSaved = githubUserRepository.save(userToSave);
        }

        return userSaved;
    }

    private GithubUserEntity attrToGithubUserEntity(Long id, Map<String, Object> attributes) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
        GithubUserEntity result = GithubUserEntity.builder()
            .id(id)
            .login(Optional.ofNullable(attributes.getOrDefault("login", ""))
                .orElse("").toString()
            )
            .nodeId(Optional.ofNullable(attributes.getOrDefault("node_id", ""))
                .orElse("").toString()
            )
            .avatarUrl(Optional.ofNullable(attributes
                .getOrDefault("avatar_url", "")).orElse("").toString()
            )
            .gravatarId(Optional.ofNullable(attributes
                .getOrDefault("gravatar_id", "")).orElse("").toString()
            )
            .htmlUrl(Optional.ofNullable(attributes.getOrDefault("html_url", ""))
                .orElse("").toString())
            .followersUrl(Optional.ofNullable(attributes
                .getOrDefault("followers_url", "")).orElse("").toString()
            )
            .followingUrl(Optional.ofNullable(attributes
                .getOrDefault("following_url", "")).orElse("").toString()
            )
            .gistsUrl(Optional.ofNullable(attributes
                .getOrDefault("gists_url", "")).orElse("").toString()
            )
            .starredUrl(Optional.ofNullable(attributes
                .getOrDefault("starred_url", "")).orElse("").toString()
            )
            .subscriptionsUrl(Optional.ofNullable(attributes
                .getOrDefault("subscriptions_url", "")).orElse("")
                .toString()
            )
            .organizationsUrl(Optional.ofNullable(attributes
                .getOrDefault("organizations_url", "")).orElse("")
                .toString()
            )
            .reposUrl(Optional.ofNullable(attributes
                .getOrDefault("repos_url", "")).orElse("").toString()
            )
            .eventsUrl(Optional.ofNullable(attributes
                .getOrDefault("events_url", "")).orElse("").toString()
            )
            .receivedEventsUrl(Optional.ofNullable(attributes
                .getOrDefault("received_events_url", "")).orElse("")
                .toString()
            )
            .type(Optional.ofNullable(attributes.getOrDefault("type", ""))
                .orElse("").toString())
            .userViewType(Optional.ofNullable(attributes
                .getOrDefault("user_view_type", "")).orElse("").toString()
            )
            .name(Optional.ofNullable(attributes.getOrDefault("name", ""))
                .orElse("").toString())
            .company(Optional.ofNullable(attributes.getOrDefault("company", ""))
                .orElse("").toString())
            .blog(Optional.ofNullable(attributes.getOrDefault("blog", ""))
                .orElse("").toString())
            .location(Optional.ofNullable(attributes.getOrDefault("location", ""))
                .orElse("").toString())
            .email(Optional.ofNullable(attributes.getOrDefault("email", ""))
                .orElse("").toString())
            .hireable(Optional.ofNullable(attributes.getOrDefault("hireable", ""))
                .orElse("").toString())
            .bio(Optional.ofNullable(attributes.getOrDefault("bio", ""))
                .orElse("").toString())
            .twitterUsername(Optional.ofNullable(attributes
                .getOrDefault("twitter_username", "")).orElse("")
                .toString()
            )
            .notificationEmail(Optional.ofNullable(attributes
                .getOrDefault("notification_email", "")).orElse("")
                .toString()
            )
            .siteAdmin(Boolean.parseBoolean(Optional.ofNullable(attributes
                .getOrDefault("site_admin", false)).orElse(false)
                .toString())
            )
            .publicRepos(Long.parseLong(Optional.ofNullable(attributes
                .getOrDefault("public_repos", "0")).orElse("0").toString())
            )
            .publicGists(Long.parseLong(Optional.ofNullable(attributes
                .getOrDefault("public_gists", "0")).orElse("0").toString())
            )
            .followers(Long.parseLong(Optional.ofNullable(attributes
                .getOrDefault("followers", "0")).orElse("0").toString())
            )
            .following(Long.parseLong(Optional.ofNullable(attributes
                .getOrDefault("following", "0")).orElse("0").toString())
            )

            .createdAt(LocalDateTime.parse(Optional.ofNullable(attributes
                    .getOrDefault("created_at", "2000-01-01T00:00:00Z"))
                    .orElse("2000-01-01T00:00:00Z").toString(),
                    formatter
                )
            )
            .updatedAt(LocalDateTime.parse(Optional.ofNullable(attributes
                    .getOrDefault("updated_at", "2000-01-01T00:00:00Z"))
                    .orElse("2000-01-01T00:00:00Z").toString(),
                    formatter
                )
            )
            
            .build();

            return result;
    }
    
}
