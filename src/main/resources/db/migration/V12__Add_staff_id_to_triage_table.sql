DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS patient_triage;

CREATE TABLE IF NOT EXISTS patient (
                                       id bigint AUTO_INCREMENT PRIMARY KEY ,
                                       p_fname VARCHAR(45) NOT NULL ,
                                       p_lname VARCHAR(45) NOT NULL ,
                                       p_mname VARCHAR(45) ,
                                       p_id_number BIGINT UNIQUE ,
                                       p_date_of_birth DATE ,
                                       p_age int NOT NULL ,
                                       p_gender VARCHAR(45),
                                       p_country VARCHAR(45) ,
                                       p_county VARCHAR(45) ,
                                       p_phone_number BIGINT UNIQUE ,
                                       p_address varchar(45),
                                       p_email_address varchar(100),
                                       p_join_date DATE

);

CREATE TABLE IF NOT EXISTS patient_triage (
                                              id bigint AUTO_INCREMENT PRIMARY KEY ,
                                              pt_weight DECIMAL(7,2),
                                              pt_temp DECIMAL (7,2),
                                              pt_height DECIMAL(7,2),
                                              pt_blood_pressure VARCHAR(45),
                                              pt_staff_name VARCHAR(45),
                                              patient_id bigint,
                                              FOREIGN KEY (patient_id) REFERENCES patient(id)
);

insert into patient (p_fname, p_lname, p_mname, p_id_number, p_date_of_birth, p_age, p_gender, p_country, p_county,
                     p_phone_number, p_address, p_email_address, p_join_date)
values ('simon', 'maina', 'kariuki', 33432121, '1997-03-12', 22, 'male', 'Kenya', 'Kiambu',
        0790166592, '776-00290', 'ximo221@gmail.com', sysdate());


insert into patient_triage (pt_weight, pt_temp, pt_height, pt_blood_pressure, pt_staff_name, patient_id) VALUES (34.4,22,133,'345 mmggh','simon',1);
