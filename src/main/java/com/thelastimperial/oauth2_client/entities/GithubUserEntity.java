package com.thelastimperial.oauth2_client.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name="github_users")
public class GithubUserEntity {
    @Id
    private Long id;

    private String login;
    private String nodeId;
    private String avatarUrl;
    private String gravatarId;
    private String htmlUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private String type;
    private String userViewType;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String hireable;
    private String bio;
    private String twitterUsername;
    private String notificationEmail;

    private Boolean siteAdmin;

    private Long publicRepos;
    private Long publicGists;
    private Long followers;
    private Long following;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
