CREATE TABLE IF NOT EXISTS user (
  id int not null AUTO_INCREMENT PRIMARY KEY,
  username varchar(45) not null unique ,
  password varchar(255) not null unique,
  fullname varchar(45) not null,
  city varchar(45) not null,
  zip varchar(45) not null,
  phonenumber int not null,
  roles varchar(45) not null
);