CREATE DATABASE carhiredb;
USE carhiredb;

CREATE TABLE IF NOT EXISTS customers (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL
) ENGINE = INNODB ;

CREATE TABLE IF NOT EXISTS cars (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	reg VARCHAR(255) NOT NULL
) ENGINE = INNODB ;


CREATE TABLE IF NOT EXISTS orders (
	order_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	cust_id BIGINT NOT NULL,
	car_id BIGINT NOT NULL,	
	FOREIGN KEY(cust_id)
		REFERENCES customers(id) 
		ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY(car_id)
		REFERENCES cars(id) 
		ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = INNODB;



INSERT INTO cars (id, name, reg)
VALUES	(1, "Toyota Corolla", "181-D-1111"),
		(2, "Ford Fiesta", "182-D-1234"),
		(3, "Nissan Qashqai", "182-D-2345");
		
INSERT INTO customers (id, firstName, lastName)
VALUES	(1, "John", "Doe"),
		(2, "Adam", "Smith"),
		(3, "Mary", "Joyce");
		
INSERT INTO orders (order_id, start_date, end_date, cust_id, car_id)
VALUES	(1, "2018-12-05", "2018-12-19", 1, 3), 
		(2, "2018-12-17", "2018-12-26", 2, 2), 
		(3, "2018-12-19", "2018-12-31", 3, 1); 
		
SELECT * FROM orders;