-- DROP Database LambtonG6;

CREATE DATABASE LambtonG6;

USE LambtonG6;

-- create an agent table that can only create customers and their bank account
CREATE TABLE AGENT (
	id INT NOT NULL AUTO_INCREMENT,
    firstName NVARCHAR(30) NOT NULL,
    lastName NVARCHAR(30) NOT NULL,
    username NVARCHAR(30) NOT NULL UNIQUE,
    password NVARCHAR(30) NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE AGENT AUTO_INCREMENT=1000;

-- account types
CREATE TABLE ACCOUNT_TYPES ( 
	ACCOUNT_TYPE_CODE NVARCHAR(30) NOT NULL PRIMARY KEY,
    DESCRIPTION NVARCHAR(250)
);

-- Bank
CREATE TABLE BANK (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL
);
ALTER TABLE BANK AUTO_INCREMENT = 1000;

-- DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	agent_id INT NOT NULL,
    firstname NVARCHAR(50) NOT NULL,
	lastname NVARCHAR(50) NOT NULL,
    age INT NOT NULL,
	username NVARCHAR(50) NOT NULL,
    password NVARCHAR(30) NOT NULL,
    email_verify BOOLEAN DEFAULT FALSE,
	email NVARCHAR(100) NOT NULL,
    address NVARCHAR(100)  NOT NULL,
    created_date DATE DEFAULT current_timestamp,
    phone_no NVARCHAR(15),
    sin_no BIGINT NOT NULL,
	CONSTRAINT fk_agent_id
    foreign key(agent_id) REFERENCES AGENT(id)
);

CREATE TABLE ACCOUNT (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	customer_id INT NOT NULL,
    account_types_code NVARCHAR(15) NOT NULL,
    bank_id INT NOT NULL,
    created_date DATE DEFAULT current_timestamp,
    balance float(10,2) default 0,
	CONSTRAINT fk_account_types_code
    foreign key(account_types_code) REFERENCES ACCOUNT_TYPES(ACCOUNT_TYPE_CODE),
    
	CONSTRAINT fk_bank_id
    foreign key(bank_id) REFERENCES BANK(id),
    
	CONSTRAINT fk_customer_id
    foreign key(customer_id) REFERENCES CUSTOMER(id)
);
ALTER TABLE ACCOUNT AUTO_INCREMENT = 1000012;

CREATE TABLE TRANSACTION_TYPES ( 
	TRANSACTION_CODE NVARCHAR(30) NOT NULL PRIMARY KEY,
    DESCRIPTION NVARCHAR(250)
);

CREATE TABLE TRANSACTIONS(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    from_account_id INT NOT NULL,
    amount float(10, 2) NOT NULL,
    created_at DATE DEFAULT current_timestamp,
    transaction_code NVARCHAR(59) NOT NULL,
    to_account_id INT,
    CONSTRAINT fk_from_account_id
    foreign key(from_account_id) REFERENCES ACCOUNT(id),
	
    CONSTRAINT fk_to_account_id
    foreign key(to_account_id) REFERENCES ACCOUNT(id),
    
	CONSTRAINT fk_transaction_type_code
    foreign key(transaction_code) REFERENCES TRANSACTION_TYPES(TRANSACTION_CODE)
);