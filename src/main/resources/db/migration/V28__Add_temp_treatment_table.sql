DROP TABLE IF EXISTS treatment_patients;

CREATE TABLE IF NOT EXISTS treatment_patients(
    id bigint AUTO_INCREMENT PRIMARY KEY ,
    status BOOLEAN DEFAULT FALSE,
    patient_id bigint,
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);

INSERT INTO treatment_patients ( status, patient_id) VALUES (false, 1);