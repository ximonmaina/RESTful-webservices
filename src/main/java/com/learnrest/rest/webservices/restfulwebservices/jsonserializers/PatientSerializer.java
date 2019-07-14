package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain.PatientTriage;
import com.learnrest.rest.webservices.restfulwebservices.pharmacy.domain.Pharmacy;
import com.learnrest.rest.webservices.restfulwebservices.treatment.domain.Treatment;

import java.io.IOException;

public class PatientSerializer extends StdSerializer<Patient> {

    public PatientSerializer() {
        this(null);
    }

    public PatientSerializer(Class<Patient> t) {
        super(t);
    }

    @Override
    public void serialize(Patient patient, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", patient.getId());
        jsonGenerator.writeStringField("patientFirstName", patient.getPatientFirstName());
        jsonGenerator.writeStringField("patientLastName", patient.getPatientLastName());
        jsonGenerator.writeStringField("patientMiddleName", patient.getPatientMiddleName());
        jsonGenerator.writeNumberField("patientIdentityNumber",patient.getPatientIdentityNumber());
        jsonGenerator.writeObjectField("patientDateOfBirth",patient.getPatientDateOfBirth());
        jsonGenerator.writeNumberField("patientAge",patient.getPatientAge());
        jsonGenerator.writeStringField("patientGender", patient.getPatientGender());
        jsonGenerator.writeStringField("patientCountry", patient.getPatientCountry());
        jsonGenerator.writeStringField("patientCounty", patient.getPatientCounty());
        jsonGenerator.writeNumberField("patientPhoneNumber", patient.getPatientPhoneNumber());
        jsonGenerator.writeStringField("patientAddress", patient.getPatientAddress());
        jsonGenerator.writeStringField("patientEmailAddress",patient.getPatientEmailAddress());
        jsonGenerator.writeArrayFieldStart("PatientTriage");
        for (PatientTriage patientTriage: patient.getPatientTriages() ) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", patientTriage.getId());
            jsonGenerator.writeNumberField("patientWeight", patientTriage.getPatientWeight());
            jsonGenerator.writeNumberField("patientTemperature", patientTriage.getPatientTemperature());
            jsonGenerator.writeNumberField("patientHeight", patientTriage.getPatinetHeight());
            jsonGenerator.writeStringField("patientBloodPressure", patientTriage.getPatientBloodPressure());
            jsonGenerator.writeStringField("staffName", patientTriage.getStaffName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeArrayFieldStart("patientTreatment");
        for (Treatment treatment: patient.getTreatments()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", treatment.getId());
            jsonGenerator.writeStringField("disease", treatment.getDisease());
            jsonGenerator.writeStringField("caseNotes", treatment.getCaseNotes());
            jsonGenerator.writeStringField("drugPrescription", treatment.getDrugPrescription());
            jsonGenerator.writeStringField("nameOfDoctor", treatment.getStaffName());
            jsonGenerator.writeObjectField("dateOfDiagnosis", treatment.getDateOfDiagnosis());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeArrayFieldStart("labData");
        for (Laboratory laboratory: patient.getLaboratories()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", laboratory.getId());
            jsonGenerator.writeStringField("testName", laboratory.getTestName());
            jsonGenerator.writeStringField("testResult", laboratory.getTestResult());
            jsonGenerator.writeObjectField("testResultDate", laboratory.getTestResultDate());
            jsonGenerator.writeStringField("staffName", laboratory.getStaffName());
            jsonGenerator.writeStringField("nameOfDoctor", laboratory.getNameOfDoctor());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeArrayFieldStart("PharmacyData");
        for (Pharmacy pharmacy : patient.getPharmacies()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", pharmacy.getId());
            jsonGenerator.writeStringField("drugName", pharmacy.getDrugName());
            jsonGenerator.writeStringField("drugDosage", pharmacy.getDrugDosage());
            jsonGenerator.writeStringField("drugNotes", pharmacy.getDrugNotes());
            jsonGenerator.writeObjectField("drugExpiryDate", pharmacy.getDrugExpiryDate());
            jsonGenerator.writeStringField("nameOfDoctor", pharmacy.getNameOfDoctor());
            jsonGenerator.writeStringField("staffName", pharmacy.getStaffName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
