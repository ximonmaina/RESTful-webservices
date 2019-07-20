ALTER TABLE pharmacy DROP COLUMN drug_name;
ALTER TABLE pharmacy DROP COLUMN drug_notes;
ALTER TABLE drug_prescription DROP COLUMN drug_prescription;
ALTER TABLE drug_prescription DROP COLUMN drug_name;


ALTER TABLE pharmacy ADD COLUMN drug_prescription TEXT;
ALTER TABLE drug_prescription ADD COLUMN drug_prescription TEXT;
update pharmacy set pharmacy.drug_prescription = '1 Drug Name: Pilton, Drug Notes: Dizzines side effects' where id = 1;
update pharmacy set pharmacy.drug_prescription = '1 Drug Name: Paracetamol, Drug Notes: No Alcohol' where id = 2;
update drug_prescription set drug_prescription = '1 Drug Name: Pilton, Drug Notes: Dizzines side effects' where id = 1;
update drug_prescription set drug_prescription = '1 Drug Name: Paracetamol, Drug Notes: No Alcohol' where id = 2;