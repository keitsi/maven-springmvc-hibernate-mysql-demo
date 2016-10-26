CREATE DATABASE demo;
USE demo;
CREATE TABLE user_info
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX table_name_id_uindex ON user_info (id);
INSERT INTO user_info (user_name, password) VALUES ("admin", "admin");