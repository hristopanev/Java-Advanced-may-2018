#DROP DATABASE report_service;

#CREATE DATABASE report_service;

#USE report_service;

CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) UNIQUE,
password VARCHAR(50) NOT NULL,
name VARCHAR(50),
gender VARCHAR(1),
birthdate DATETIME,
age INT,
email VARCHAR(50) NOT NULL
);

CREATE TABLE departments(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL
);

CREATE TABLE employees(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(25),
last_name VARCHAR(25),
gender VARCHAR(1),
birthdate DATETIME,
age INT,
department_id INT NOT NULL,
CONSTRAINT fk_department_id_employees
FOREIGN KEY (department_id)
REFERENCES departments(id)
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
department_id INT,
CONSTRAINT fk_department_id_categories FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE status(
id INT PRIMARY KEY AUTO_INCREMENT,
label VARCHAR(30) NOT NULL
);

CREATE TABLE reports(
id INT PRIMARY KEY AUTO_INCREMENT,
category_id INT NOT NULL, 
CONSTRAINT fk_category_id_reports FOREIGN KEY (category_id) REFERENCES categories(id),
status_id INT NOT NULL,
CONSTRAINT fk_status_id_reports FOREIGN KEY (status_id) REFERENCES status(id),
open_date DATETIME,
close_date DATETIME,
description VARCHAR(200),
user_id INT NOT NULL,
CONSTRAINT fk_user_id_reports FOREIGN KEY (user_id) REFERENCES users(id),
employee_id INT,
CONSTRAINT fk_employee_id_reports FOREIGN KEY (employee_id) REFERENCES employees(id)
);