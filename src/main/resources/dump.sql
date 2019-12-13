DROP DATABASE IF EXISTS customer_logs;
CREATE DATABASE customer_logs
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

create table clients
(
    id         int auto_increment
        primary key,
    first_name varchar(255) null,
    last_name  varchar(255) null
);
