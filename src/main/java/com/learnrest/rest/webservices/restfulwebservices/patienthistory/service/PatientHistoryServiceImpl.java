package com.learnrest.rest.webservices.restfulwebservices.patienthistory.service;

import com.learnrest.rest.webservices.restfulwebservices.patienthistory.datasource.SpringJdbcConfig;
import com.learnrest.rest.webservices.restfulwebservices.patienthistory.domain.PatientHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

@Service
public class PatientHistoryServiceImpl {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientHistoryServiceImpl(final SpringJdbcConfig dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource.mysqlDataSource());
    }

    public Collection<PatientHistory> retrievePatientHistory(Long patientId) {
        final PatientHistoryMapper patientHistoryMapper = new PatientHistoryMapper();
        final String sql = "select DISTINCT " + patientHistoryMapper.schema() + "  WHERE  laboratory.test_result_date AND treatment.date_of_diagnosis=patient_triage.triage_date  AND patient.id = ?";
        return this.jdbcTemplate.query(sql, patientHistoryMapper, new Object[] {patientId});
    }

    private static final class PatientHistoryMapper implements RowMapper<PatientHistory> {

        public PatientHistoryMapper(){}

        public String schema() {
            return "patient.p_fname as firstName, patient.p_mname as middleName, patient.p_lname as lastName, patient.p_age as age, patient.p_gender as gender, " +
                    "patient_triage.pt_weight as weight, patient_triage.pt_temp as temperature, patient_triage.pt_height as height, patient_triage.pt_blood_pressure as bloodPressure, " +
                    "patient_triage.pt_staff_name as nurseName, patient_triage.triage_date as triageDate, " +
                    "treatment.t_disease as disease, treatment.t_notes as treatmentNotes, treatment.t_staff_name as doctorName, treatment.drug_prescription as drugPrescription, " +
                    "laboratory.test_name as testName, laboratory.test_result as testResult, laboratory.staff_name as labTechName " +
                    "from patient join patient_triage on patient_triage.patient_id=patient.id join treatment on treatment.patient_id=patient.id join treatment_laboratory on " +
                    "treatment_laboratory.treatment_id=treatment.id  join laboratory on laboratory.id=treatment_laboratory.laboratory_id ";
        }

        @Override
        public PatientHistory mapRow(final ResultSet rs, @SuppressWarnings("unused") final int rowNum) throws SQLException {
            // Patient
            final String patientFirstName = rs.getString("firstName");
            final String patientLastName = rs.getString("middleName");
            final String patientMiddleName = rs.getString("lastName");
            final int patientAge = rs.getInt("age");
            final String patientGender = rs.getString("gender");

            // triage data
            final double patientWeight = rs.getDouble("weight");
            final double patientTemperature = rs.getDouble("temperature");
            final double patientHeight = rs.getDouble("height");
            final String patientBloodPressure = rs.getString("bloodPressure");
            final String nurseName = rs.getString("nurseName");
            final Date triageDate = rs.getDate("triageDate");

            // treatment
            final String disease = rs.getString("disease");
            final String caseNotes = rs.getString("treatmentNotes");
            final String doctorName = rs.getString("doctorName");
            final String drugPrescription = rs.getString("drugPrescription");

            // laboratory
            final String testName = rs.getString("testName");
            final String testResult = rs.getString("testResult");
            final String labTechName = rs.getString("labTechName");

            return new PatientHistory(patientFirstName,patientLastName,patientMiddleName,patientAge,patientGender,patientWeight,patientTemperature,
                    patientHeight,patientBloodPressure,nurseName,triageDate,disease,caseNotes,doctorName,drugPrescription,testName,testResult,labTechName);
        }
    }
}
