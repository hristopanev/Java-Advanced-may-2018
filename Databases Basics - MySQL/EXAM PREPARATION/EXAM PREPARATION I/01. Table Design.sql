CREATE TABLE towns(
town_id INT PRIMARY KEY,
town_name VARCHAR(30) NOT NULL
);

CREATE TABLE airports(
airport_id INT PRIMARY KEY,
airport_name VARCHAR(50) NOT NULL,
town_id INT,
CONSTRAINT fk_town_id_airports
FOREIGN KEY (town_id)
REFERENCES towns(town_id)
);

CREATE TABLE airlines(
airline_id INT PRIMARY KEY,
airline_name VARCHAR(30) NOT NULL,
nationality VARCHAR(30) NOT NULL,
rating INT DEFAULT 0
);

CREATE TABLE customers(
customer_id INT PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
date_of_birth DATE NOT NULL,
gender VARCHAR(1) NOT NULL,
home_town_id INT,
CONSTRAINT fk_home_town_id
FOREIGN KEY(home_town_id)
REFERENCES towns(town_id)
);

CREATE TABLE flights(
flight_id INT PRIMARY KEY AUTO_INCREMENT,
departure_time DATETIME NOT NULL,
arrival_time DATETIME NOT NULL,
status VARCHAR(9) NOT NULL,
origin_airport_id INT,
CONSTRAINT fk_origin_airport_id_flights
FOREIGN KEY(origin_airport_id)
REFERENCES airports(airport_id),
destination_airport_id INT,
CONSTRAINT fk_destination_airport_id_flights
FOREIGN KEY(destination_airport_id)
REFERENCES airports(airport_id),
airline_id INT,
CONSTRAINT fk_airline_id_flights_flights
FOREIGN KEY(airline_id)
REFERENCES airlines(airline_id)
);

CREATE TABLE tickets(
ticket_id INT PRIMARY KEY AUTO_INCREMENT,
price DECIMAL(8,2) NOT NULL,
class VARCHAR(6) NOT NULL,
seat VARCHAR(5) NOT NULL,
customer_id INT,
CONSTRAINT fk_customer_id_tickets
FOREIGN KEY(customer_id)
REFERENCES customers(customer_id),
flight_id INT,
CONSTRAINT fk_flight_id_tickets
FOREIGN KEY (flight_id)
REFERENCES flights(flight_id)
);