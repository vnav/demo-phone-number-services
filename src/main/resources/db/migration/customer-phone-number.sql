CREATE TABLE customers (
	customer_id UUID NOT NULL PRIMARY KEY,
	firstname VARCHAR(50),
	lastname VARCHAR(50)
);

CREATE TABLE customer_accounts (
	account_id UUID NOT NULL PRIMARY KEY,
	customer_id UUID NOT NULL,
	
	CONSTRAINT fk_customer_account FOREIGN KEY(customer_id) REFERENCES customers (customer_id)
);

CREATE TABLE customer_phone_numbers (
	id BIGINT(8) NOT NULL PRIMARY KEY,
	customer_id UUID NOT NULL,
	type VARCHAR(16) NOT NULL,
	phone_number(16) NOT NULL,'
	status VARCHAR(16) NOT NULL,
	
	CONSTRAINT fk_customer_phone FOREIGN KEY(customer_id) REFERENCES customers (customer_id)
);


CREATE TABLE activation_phone_number (
	activation_code UUID NOT NULL PRIMARY KEY,
	customer_phone_number_id BIGINT(8) NOT NULL,
	status VARCHAR(16) NOT NULL DEFAULT 'NEW',
	create_dt TIMESTAMP,
	update_dt TIMESTAMP,
	
	CONSTRAINT fk_customer_phone_activation FOREIGN KEY(customer_phone_number_id) REFERENCES customer_phone_numbers (id)
);