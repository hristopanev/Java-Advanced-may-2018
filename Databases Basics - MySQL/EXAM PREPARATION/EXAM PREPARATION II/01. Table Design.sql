CREATE TABLE credentials(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
email VARCHAR(30) NOT NULL,
password VARCHAR(20) NOT NULL
);

CREATE TABLE locations(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
latitude FLOAT,
longitude FLOAT
);

CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
nickname VARCHAR(25) NOT NULL,
gender CHAR(1) NOT NULL,
age INT NOT NULL,
location_id INT,
CONSTRAINT fk_location_id_users
FOREIGN KEY (location_id)
REFERENCES locations(id),
credential_id INT UNIQUE,
CONSTRAINT fk_credential_id_users
FOREIGN KEY (credential_id)
REFERENCES credentials(id)
);

CREATE TABLE chats(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
title VARCHAR(32) NOT NULL,
start_date DATE NOT NULL,
is_active BIT NOT NULL
);

CREATE TABLE messages(
id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
content VARCHAR(200) NOT NULL,
sent_on DATE,
chat_id INT ,
CONSTRAINT chat_id_messages
FOREIGN KEY (chat_id)
REFERENCES chats(id),
user_id INT,
CONSTRAINT user_id_messages
FOREIGN KEY (user_id)
REFERENCES users(id)
);

CREATE TABLE users_chats(
user_id INT,
chat_id INT,
CONSTRAINT pk_users_chats PRIMARY KEY (user_id, chat_id),
CONSTRAINT user_id_users_chats
FOREIGN KEY (user_id)
REFERENCES users(id),
CONSTRAINT chat_id_users_chats
FOREIGN KEY (chat_id)
REFERENCES chats(id)
);