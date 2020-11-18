INSERT INTO TB_FILMS(name, genre, release_year) VALUES('inception', 'thriller', 2010);
INSERT INTO TB_FILMS(name, genre, release_year) VALUES('forrest gump', 'drama', 1992);
INSERT INTO TB_FILMS(name, genre, release_year) VALUES('enter the dragon', 'adventure', 1973);
INSERT INTO TB_FILMS(name, genre, release_year) VALUES('enter the dragon 2', 'adventure', 1974);
INSERT INTO TB_FILMS(name, genre, release_year) VALUES('enter the dragon 3', 'adventure', 1977);

INSERT INTO USER(name, email, password) VALUES('admin', 'admin@films.com', '$2a$10$XAzYDwFxPJNAshMotBsHU.tyAYICXeGZWfqkG6hu.pSc7RlLVQA1S');
INSERT INTO USER(name, email, password) VALUES('user', 'user@films.com', '$2a$10$XAzYDwFxPJNAshMotBsHU.tyAYICXeGZWfqkG6hu.pSc7RlLVQA1S');

INSERT INTO PROFILE(id, name) VALUES(1, 'ROLE_ADMIN');
INSERT INTO PROFILE(id, name) VALUES(2, 'ROLE_USER');

INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES(1, 1);
INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES(2, 2);


