DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    user_name  varchar(45) not null unique,
    password varchar(255) not null unique ,
    first_name varchar(45),
    last_name varchar(45),
    middle_name varchar(45),
    display_name varchar(45),
    country varchar(20),
    county varchar(20),
    phone_number varchar(20) unique ,
    roles varchar(45),
    id_number int unique ,
    email_address varchar(100) not null,
    po_box_address varchar(45),
    join_date DATE

);