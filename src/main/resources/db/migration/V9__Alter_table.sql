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

insert into user (user_name, password, first_name, last_name, middle_name, display_name, country,
                  county, phone_number, roles, id_number, email_address, po_box_address, join_date) VALUES
('simon', '$2a$10$gagtrG42yfMu5dHnxmE0PewUgcJI1PP4S1OIRa5aXlLvS.GK7uO5q', 'Simon','Maina', 'Kariuki', ' Simon Maina', 'Kenya', 'Kiambu', '+254790166592','ADMIN',
 33212212, 'simonmaina721@gmail.com','776-00290', sysdate());