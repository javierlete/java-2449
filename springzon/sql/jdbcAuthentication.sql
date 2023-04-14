CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);
  
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);

-- https://bcrypt-generator.com/

-- User user/pass
INSERT INTO users (username, password, enabled)
  values ('javier',
    '$2a$12$/AY0/zbOo3CKTZE6.b41TOcHyP.VMLCHVbsfiW3KnVLcYe3pz/VLC',
    1),
    ('pepe',
    '$2a$12$i2vbn0K2ttmBOsUFaH98TOAyHb8HeyPABEq.IceE6TvlumEOJwwb.',
    1);

INSERT INTO authorities (username, authority)
  values ('javier', 'ROLE_ADMIN'), ('pepe', 'ROLE_USER');