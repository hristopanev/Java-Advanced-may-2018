DROP DATABAse instagraph_db;

CREATE DATABASE instagraph_db;

use instagraph_db;


CREATE TABLE pictures(
id INT PRIMARY KEY AUTO_INCREMENT,
path VARCHAR(255) NOT NULL,
size DECIMAL(10,2) NOT NULL
);

CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL UNIQUE,
password VARCHAR(30) NOT NULL,
profile_picture_id INT,
CONSTRAINT fk_profile_picture_id_user
FOREIGN KEY (profile_picture_id)
REFERENCES pictures(id)
);

CREATE TABLE posts(
id INT PRIMARY KEY AUTO_INCREMENT,
caption VARCHAR(255) NOT NULL,
user_id INT NOT NULL,
CONSTRAINT fk_user_id_posts
FOREIGN KEY (user_id)
REFERENCES users(id),
picture_id INT NOT NULL,
CONSTRAINT fk_picture_id_posts
FOREIGN KEY (picture_id)
REFERENCES pictures(id)
);

CREATE TABLE comments(
id INT PRIMARY KEY AUTO_INCREMENT,
content VARCHAR(255) NOT NULL,
user_id INT NOT NULL,
CONSTRAINT fk_user_id_comments
FOREIGN KEY (user_id)
REFERENCES users(id),
post_id INT NOT NULL,
CONSTRAINT fk_post_id_comments
FOREIGN KEY (post_id)
REFERENCES posts(id)
);

CREATE TABLE users_followers(
user_id INT, 
follower_id INT,
CONSTRAINT fk_user_id_uf
FOREIGN KEY (user_id)
REFERENCES users(id),
CONSTRAINT fk_follower_id_uf
FOREIGN KEY (follower_id)
REFERENCES users(id)
);