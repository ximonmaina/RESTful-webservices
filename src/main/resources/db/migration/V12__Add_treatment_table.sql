DROP TABLE IF EXISTS treatment;
DROP TABLE IF EXISTS laboratory;
DROP TABLE IF EXISTS pharmacy;
DROP TABLE IF EXISTS lab_test_request;
DROP TABLE IF EXISTS drug_prescription;



CREATE TABLE IF NOT EXISTS treatment (
    id bigint AUTO_INCREMENT PRIMARY KEY ,
    t_disease VARCHAR(255),
    t_notes TEXT,
    drug_prescription VARCHAR(255),
    t_staff_name VARCHAR(100),
    date_of_diagnosis DATE,
    patient_id bigint,
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);

CREATE TABLE IF NOT EXISTS laboratory (
  id bigint AUTO_INCREMENT PRIMARY KEY ,
  test_name varchar(255),
  test_result TEXT,
  test_result_date DATE,
  staff_name varchar(100),
  patient_id bigint,
  FOREIGN KEY (patient_id) REFERENCES patient(id)
);

CREATE TABLE IF NOT EXISTS pharmacy (
    id bigint AUTO_INCREMENT PRIMARY KEY ,
    drug_name varchar(255),
    drug_dosage varchar(45),
    drug_notes TEXT,
    drug_expiry_date DATE,
    staff_name varchar(100),
    patient_id bigint,
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);

CREATE TABLE IF NOT EXISTS lab_test_request (
    id bigint AUTO_INCREMENT PRIMARY KEY ,
    test_name VARCHAR(255),
    date_of_request DATE,
    doctor_name VARCHAR(100),
    patient_id bigint,
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);

CREATE TABLE IF NOT EXISTS drug_prescription (
    id bigint AUTO_INCREMENT PRIMARY KEY ,
    drug_prescription TEXT,
    doctor_name varchar(100),
    date_of_prescription DATE,
    patient_id bigint,
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);

INSERT INTO treatment (t_disease, t_notes, drug_prescription, t_staff_name, date_of_diagnosis, patient_id) VALUES ('malaria','general high fever and extreme shivering with stiff joints','Anti-malaria drugs', 'Simon Maina','2019-07-13',1);