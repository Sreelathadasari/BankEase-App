CREATE DATABASE bankdb;
USE bankdb;

CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    holder_name VARCHAR(100),
    balance DOUBLE,
    account_type VARCHAR(20),
    created_date DATE
);