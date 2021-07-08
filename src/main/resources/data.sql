INSERT INTO customers (customer_id, firstname, lastname) VALUES (1, 'John', 'Hill');
INSERT INTO customers (customer_id, firstname, lastname) VALUES (2, 'Peter', 'Wilson');
INSERT INTO customers (customer_id, firstname, lastname) VALUES (3, 'Lex', 'Jackson');

INSERT INTO customer_accounts (account_id, customer_id) VALUES (10, 1);
INSERT INTO customer_accounts (account_id, customer_id) VALUES (20, 2);
INSERT INTO customer_accounts (account_id, customer_id) VALUES (30, 3);

INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (100, 1, 'MOBILE', '0477777777', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (101, 1, 'HOME', '2477777777', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (102, 1, 'OFFICE', '2487777777', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (200, 2, 'MOBILE', '0488888888', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (201, 2, 'HOME', '2488888888', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (300, 3, 'MOBILE', '0499999999', 'INACTIVE');
INSERT INTO customer_phone_numbers (id, customer_id, type, phone_number, status) VALUES (301, 3, 'HOME', '2499999999', 'INACTIVE');

INSERT INTO activation_phone_number (activation_code, customer_phone_number_id, status, create_dt, update_dt) VALUES (1000, 100, 'NEW', '2021-07-08 19:55:58.280000', '2021-07-08 19:55:58.280000');
INSERT INTO activation_phone_number (activation_code, customer_phone_number_id, status, create_dt, update_dt) VALUES (2000, 200, 'NEW', '2021-07-08 19:55:58.280000', '2021-07-08 19:55:58.280000');
INSERT INTO activation_phone_number (activation_code, customer_phone_number_id, status, create_dt, update_dt) VALUES (3000, 300, 'NEW', '2021-07-08 19:55:58.280000', '2021-07-08 19:55:58.280000');

