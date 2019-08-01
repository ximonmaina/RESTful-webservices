ALTER TABLE treatment_patients ADD test_result boolean DEFAULT false;
ALTER TABLE treatment_patients ADD name_of_doctor VARCHAR(255);

# update treatment_patients set treatment_patients.test_result = false where id = 1;