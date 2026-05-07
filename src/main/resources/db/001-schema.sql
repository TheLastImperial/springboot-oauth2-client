CREATE TABLE oauth2_authorized_client (
  client_registration_id varchar(100) NOT NULL,
  principal_name varchar(200) NOT NULL,
  access_token_type varchar(100) NOT NULL,
  access_token_value BYTEA NOT NULL,
  access_token_issued_at timestamp NOT NULL,
  access_token_expires_at timestamp NOT NULL,
  access_token_scopes varchar(1000) DEFAULT NULL,
  refresh_token_value BYTEA DEFAULT NULL,
  refresh_token_issued_at timestamp DEFAULT NULL,
  created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (client_registration_id, principal_name)
);


CREATE TABLE github_users (
  id INTEGER,

  login VARCHAR(255),
  node_id VARCHAR(255),
  avatar_url VARCHAR(255),
  gravatar_id VARCHAR(255),
  html_url VARCHAR(255),
  followers_url VARCHAR(255),
  following_url VARCHAR(255),
  gists_url VARCHAR(255),
  starred_url VARCHAR(255),
  subscriptions_url VARCHAR(255),
  organizations_url VARCHAR(255),
  repos_url VARCHAR(255),
  events_url VARCHAR(255),
  received_events_url VARCHAR(255),
  type VARCHAR(255),
  user_view_type VARCHAR(255),
  name VARCHAR(255),
  company VARCHAR(255),
  blog VARCHAR(255),
  location VARCHAR(255),
  email VARCHAR(255),
  hireable VARCHAR(255),
  bio VARCHAR(255),
  twitter_username VARCHAR(255),
  notification_email VARCHAR(255),

  site_admin BOOLEAN,

  public_repos INTEGER,
  public_gists INTEGER,
  followers INTEGER,
  following INTEGER,

  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  PRIMARY KEY(id)
);

CREATE TABLE google_users (
  id VARCHAR(255),
  iss VARCHAR(255),
  picture VARCHAR(255),
  name VARCHAR(255),
  email VARCHAR(255),

  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  PRIMARY KEY(id)
);

CREATE TABLE oidc_users (
  id VARCHAR(255),
  iss VARCHAR(255),
  picture VARCHAR(255),
  name VARCHAR(255),
  email VARCHAR(255),

  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  PRIMARY KEY(id)
);
