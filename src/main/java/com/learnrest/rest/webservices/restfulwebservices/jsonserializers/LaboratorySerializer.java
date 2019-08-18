package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;

import java.io.IOException;

public class LaboratorySerializer extends StdSerializer<Laboratory> {

    public LaboratorySerializer() { this(null); }

    public LaboratorySerializer(Class<Laboratory> t) { super(t); }

    @Override
    public void serialize(Laboratory laboratory, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", laboratory.getId());
        jsonGenerator.writeStringField("testName", laboratory.getTestName());
        jsonGenerator.writeStringField("testResult", laboratory.getTestResult());
        jsonGenerator.writeObjectField("testResultDate", laboratory.getTestResultDate());
        jsonGenerator.writeStringField("staffName", laboratory.getStaffName());
        jsonGenerator.writeStringField("nameOfDoctor", laboratory.getNameOfDoctor());
        jsonGenerator.writeArrayFieldStart("patient");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", laboratory.getPatient().getId());
        jsonGenerator.writeStringField("patientFirstName", laboratory.getPatient().getPatientFirstName());
        jsonGenerator.writeStringField("patientLastName", laboratory.getPatient().getPatientLastName());
        jsonGenerator.writeStringField("patientMiddleName", laboratory.getPatient().getPatientMiddleName());
        jsonGenerator.writeNumberField("patientIdentityNumber",laboratory.getPatient().getPatientIdentityNumber());
        jsonGenerator.writeObjectField("patientDateOfBirth",laboratory.getPatient().getPatientDateOfBirth());
        jsonGenerator.writeNumberField("patientAge",laboratory.getPatient().getPatientAge());
        jsonGenerator.writeStringField("patientGender", laboratory.getPatient().getPatientGender());
        jsonGenerator.writeStringField("patientCountry", laboratory.getPatient().getPatientCountry());
        jsonGenerator.writeStringField("patientCounty", laboratory.getPatient().getPatientCounty());
        jsonGenerator.writeNumberField("patientPhoneNumber", laboratory.getPatient().getPatientPhoneNumber());
        jsonGenerator.writeStringField("patientEmailAddress",laboratory.getPatient().getPatientEmailAddress());
        jsonGenerator.writeStringField("patientClinicId", laboratory.getPatient().getPatientClinicId());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();

    }
}
