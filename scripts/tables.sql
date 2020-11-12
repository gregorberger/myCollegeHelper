create database if not exists Data;

use Data;

CREATE TABLE if not exists Data.user_info (
        id INT NOT NULL AUTO_INCREMENT,
        first_name VARCHAR(100),
        last_name VARCHAR(100),
        email VARCHAR(150),
        insert_date DATE,
        session_id VARCHAR(500),
        primary key (id)
);