INSERT INTO customers (customer_id, firstname, lastname) VALUES (11, 'John', 'Hill');
INSERT INTO customers (customer_id, firstname, lastname) VALUES (12, 'Peter', 'Wilson');
INSERT INTO customers (customer_id, firstname, lastname) VALUES (13, 'Lex', 'Jackson');

INSERT INTO customer_accounts (account_id, customer_id) VALUES (101, 11);
INSERT INTO customer_accounts (account_id, customer_id) VALUES (201, 12);
INSERT INTO customer_accounts (account_id, customer_id) VALUES (301, 13);


INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (1000, 11, 'MOBILE', '0477777777', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (1001, 11, 'HOME', '2477777777', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (1002, 11, 'OFFICE', '2487777777', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (2000, 12, 'MOBILE', '0488888888', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (2001, 12, 'HOME', '2488888888', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (3000, 13, 'MOBILE', '0499999999', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (3001, 13, 'HOME', '2499999999', 'INACTIVE');


INSERT INTO activation_phone_number (activation_code, customer_phone_number_id, status, create_dt, update_dt) VALUES (10000, 1000, 'NEW', '2021-07-08 19:55:58.280000', '2021-07-08 19:55:58.280000');
INSERT INTO activation_phone_number (activation_code, customer_phone_number_id, status, create_dt, update_dt) VALUES (20000, 2000, 'NEW', '2021-07-08 19:55:58.280000', '2021-07-08 19:55:58.280000');
INSERT INTO activation_phone_number (activation_code, customer_phone_number_id, status, create_dt, update_dt) VALUES (30000, 3000, 'NEW', '2021-07-08 19:55:58.280000', '2021-07-08 19:55:58.280000');

