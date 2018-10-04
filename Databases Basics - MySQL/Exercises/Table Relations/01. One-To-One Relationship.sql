CREATE TABLE passports(
passport_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
passport_number VARCHAR(8) UNIQUE
);

CREATE TABLE persons(
person_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
salary DECIMAL(10,2),
passport_id INT UNSIGNED UNIQUE,
FOREIGN KEY (passport_id) REFERENCES passports(passport_id)
);

INSERT INTO passports(passport_id, passport_number)
VALUES (101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

INSERT INTO persons(first_name, salary, passport_id)
VALUES ('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);