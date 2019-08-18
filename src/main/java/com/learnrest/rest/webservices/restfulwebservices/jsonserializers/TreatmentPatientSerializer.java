package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.domain.TreatmentPatients;

import java.io.IOException;

public class TreatmentPatientSerializer extends StdSerializer<TreatmentPatients> {

    public TreatmentPatientSerializer() { this(null);}

    public TreatmentPatientSerializer(Class<TreatmentPatients> t) { super(t);}

    @Override
    public void serialize(TreatmentPatients treatmentPatients, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", treatmentPatients.getId());
        jsonGenerator.writeBooleanField("status", treatmentPatients.isStatus());
        jsonGenerator.writeBooleanField("testResult", treatmentPatients.isTestResult());
        jsonGenerator.writeStringField("nameOfDoctor", treatmentPatients.getNameOfDoctor());
        jsonGenerator.writeArrayFieldStart("patient");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", treatmentPatients.getPatient().getId());
        jsonGenerator.writeStringField("patientFirstName", treatmentPatients.getPatient().getPatientFirstName());
        jsonGenerator.writeStringField("patientLastName", treatmentPatients.getPatient().getPatientLastName());
        jsonGenerator.writeStringField("patientMiddleName", treatmentPatients.getPatient().getPatientMiddleName());
        jsonGenerator.writeNumberField("patientIdentityNumber",treatmentPatients.getPatient().getPatientIdentityNumber());
        jsonGenerator.writeObjectField("patientDateOfBirth",treatmentPatients.getPatient().getPatientDateOfBirth());
        jsonGenerator.writeNumberField("patientAge",treatmentPatients.getPatient().getPatientAge());
        jsonGenerator.writeStringField("patientGender", treatmentPatients.getPatient().getPatientGender());
        jsonGenerator.writeStringField("patientCountry", treatmentPatients.getPatient().getPatientCountry());
        jsonGenerator.writeStringField("patientCounty", treatmentPatients.getPatient().getPatientCounty());
        jsonGenerator.writeNumberField("patientPhoneNumber", treatmentPatients.getPatient().getPatientPhoneNumber());
        jsonGenerator.writeStringField("patientEmailAddress",treatmentPatients.getPatient().getPatientEmailAddress());
        jsonGenerator.writeStringField("patientClinicId", treatmentPatients.getPatient().getPatientClinicId());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
