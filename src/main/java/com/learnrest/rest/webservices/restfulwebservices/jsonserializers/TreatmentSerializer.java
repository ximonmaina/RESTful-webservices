package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.treatment.domain.Treatment;

import java.io.IOException;

public class TreatmentSerializer extends StdSerializer<Treatment> {

    public TreatmentSerializer() { this(null);}

    public TreatmentSerializer(Class<Treatment> t) { super(t); }

    @Override
    public void serialize(Treatment treatment, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", treatment.getId());
        jsonGenerator.writeStringField("disease", treatment.getDisease());
        jsonGenerator.writeStringField("caseNotes", treatment.getCaseNotes());
        jsonGenerator.writeStringField("drugPrescription", treatment.getDrugPrescription());
        jsonGenerator.writeStringField("staffName", treatment.getStaffName());
        jsonGenerator.writeObjectField("dateOfDiagnosis", treatment.getDateOfDiagnosis());
        jsonGenerator.writeArrayFieldStart("patient");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", treatment.getPatient().getId());
        jsonGenerator.writeStringField("patientFirstName", treatment.getPatient().getPatientFirstName());
        jsonGenerator.writeStringField("patientLastName", treatment.getPatient().getPatientLastName());
        jsonGenerator.writeStringField("patientMiddleName", treatment.getPatient().getPatientMiddleName());
        jsonGenerator.writeNumberField("patientIdentityNumber",treatment.getPatient().getPatientIdentityNumber());
        jsonGenerator.writeObjectField("patientDateOfBirth",treatment.getPatient().getPatientDateOfBirth());
        jsonGenerator.writeNumberField("patientAge",treatment.getPatient().getPatientAge());
        jsonGenerator.writeStringField("patientGender", treatment.getPatient().getPatientGender());
        jsonGenerator.writeStringField("patientCountry", treatment.getPatient().getPatientCountry());
        jsonGenerator.writeStringField("patientCounty", treatment.getPatient().getPatientCounty());
        jsonGenerator.writeNumberField("patientPhoneNumber", treatment.getPatient().getPatientPhoneNumber());
        jsonGenerator.writeStringField("patientEmailAddress",treatment.getPatient().getPatientEmailAddress());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
