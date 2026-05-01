# OAuth2 Client example

This repository is to show the configurations for `OAuth2 client`.

## Set ClientRegistration

Create the file `.env` and set the variables:
 - `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GITHUB_CLIENTID`
 - `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GITHUB_CLIENTSECRET`

## Database

Add the next env var to the file `.env`:
 - `SPRING_DATASOURCE_URL`
 - `SPRING_DATASOURCE_USERNAME`
 - `SPRING_DATASOURCE_PASSWORD`

## SecurityFilterChain

The SecurityFilterChain set the path `/` for every body and any other
request need authentication, this create a specific url for the role
`USER` and `ADMIN`.

## GrantedAuthoritiesMapper

Set the `GrantedAuthority` for the `OAuth2AuthorizedClient` on this
case set the role `USER`.
