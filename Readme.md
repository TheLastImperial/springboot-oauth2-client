# OAuth2 Client example

This repository is to show the configurations for `OAuth2 client`.

## Set ClientRegistration

Create the file `.env` and the the variables
`SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GITHUB_CLIENTID`
and `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GITHUB_CLIENTSECRET`.

## SecurityFilterChain

The SecurityFilterChain set the path `/` for every body and any other
request need authentication, this create a specific url for the role
`USER` and `ADMIN`.

## GrantedAuthoritiesMapper

Set the `GrantedAuthority` for the `OAuth2AuthorizedClient` on this
case set the roles `USER` and `GITHUB`.
