package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain.PatientTriage;

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
        jsonGenerator.writeEndObject();
    }
}
