ALTER TABLE  pharmacy ADD drug_prescription_date DATE;
ALTER TABLE drug_prescription ADD number_of_days VARCHAR(45);
ALTER TABLE drug_prescription ADD usage_per_day varchar(45);

update pharmacy set drug_prescription_date = '2019-07-19' where id = 1;
update pharmacy set drug_prescription_date = '2019-07-19' where id = 2;