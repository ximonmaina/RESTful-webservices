ALTER TABLE  drug_prescription ADD drug_name VARCHAR(45);
update drug_prescription set drug_prescription.drug_name = 'Panadol' where id = 1;
update drug_prescription set drug_prescription.drug_name = 'Pilton' where id = 2;
