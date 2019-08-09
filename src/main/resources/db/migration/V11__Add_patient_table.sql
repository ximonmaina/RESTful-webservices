DROP TABLE IF EXISTS patient;

CREATE TABLE IF NOT EXISTS patient (
    id bigint AUTO_INCREMENT PRIMARY KEY ,
    p_fname VARCHAR(45) NOT NULL ,
    p_lname VARCHAR(45) NOT NULL ,
    p_mname VARCHAR(45) ,
    p_id_number BIGINT ,
    p_date_of_birth DATE ,
    p_age int NOT NULL ,
    p_gender VARCHAR(45),
    p_country VARCHAR(45) ,
    p_county VARCHAR(45) ,
    p_phone_number BIGINT,
    p_address varchar(45),
    p_email_address varchar(100),
    p_join_date DATE

);

INSERT INTO patient_management_system.patient ( p_fname, p_lname, p_mname, p_id_number, p_date_of_birth, p_age, p_gender, p_country, p_county, p_phone_number, p_address, p_email_address, p_join_date) VALUES ( 'simon', 'maina', 'kariuki', 33432121, '1997-03-12', 22, 'male', 'Kenya', 'Kiambu', 790166592, '776-00290', 'ximo221@gmail.com', '2019-08-01');
INSERT INTO patient_management_system.patient ( p_fname, p_lname, p_mname, p_id_number, p_date_of_birth, p_age, p_gender, p_country, p_county, p_phone_number, p_address, p_email_address, p_join_date) VALUES ( 'John', 'Kariuki', 'Maina', 33556734, '1986-12-28', 45, 'male', 'Kenya', 'Nakuru', 721167324, '776-00290', 'johnk@gmail.com', '2019-08-01');
INSERT INTO patient_management_system.patient ( p_fname, p_lname, p_mname, p_id_number, p_date_of_birth, p_age, p_gender, p_country, p_county, p_phone_number, p_address, p_email_address, p_join_date) VALUES ( 'Duncan', 'Nandwa', 'Okeno', 33452216, '1995-01-01', 25, 'male', 'Kenya', 'Kakamega', 790134123, '998-00290', 'duncanokeno@gmail.com', '2019-08-01');
INSERT INTO patient_management_system.patient ( p_fname, p_lname, p_mname, p_id_number, p_date_of_birth, p_age, p_gender, p_country, p_county, p_phone_number, p_address, p_email_address, p_join_date) VALUES ( 'Charity', 'Njeri', 'Warui', 0, '1998-12-27', 21, 'female', 'Kenya', 'Kiambu', 723345543, '776-00290', 'charity@gmail.com', '2019-08-01');
INSERT INTO patient_management_system.patient ( p_fname, p_lname, p_mname, p_id_number, p_date_of_birth, p_age, p_gender, p_country, p_county, p_phone_number, p_address, p_email_address, p_join_date) VALUES ('Benedict', 'Joe', 'Njoroge', 45698756, '1990-12-30', 30, 'male', 'Kenya', 'Kiambu', 774564123, '776-00290', 'ximo222@gmail.com', '2019-08-02');