package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.drugprescription.domain.DrugPrescription;

import java.io.IOException;

public class DrugPrescriptionSerializer extends StdSerializer<DrugPrescription> {

    public DrugPrescriptionSerializer() { this(null);}

    public DrugPrescriptionSerializer(Class<DrugPrescription> t) { super(t);}

    @Override
    public void serialize(DrugPrescription drugPrescription, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", drugPrescription.getId());
        jsonGenerator.writeStringField("drugPrescription", drugPrescription.getDrugPrescription());
        jsonGenerator.writeStringField("doctorName", drugPrescription.getDoctorName());
        jsonGenerator.writeObjectField("dateOfPrescription", drugPrescription.getDateOfPrescription());
        jsonGenerator.writeArrayFieldStart("patient");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", drugPrescription.getPatient().getId());
        jsonGenerator.writeStringField("patientFirstName", drugPrescription.getPatient().getPatientFirstName());
        jsonGenerator.writeStringField("patientLastName", drugPrescription.getPatient().getPatientLastName());
        jsonGenerator.writeStringField("patientMiddleName", drugPrescription.getPatient().getPatientMiddleName());
        jsonGenerator.writeNumberField("patientIdentityNumber",drugPrescription.getPatient().getPatientIdentityNumber());
        jsonGenerator.writeObjectField("patientDateOfBirth",drugPrescription.getPatient().getPatientDateOfBirth());
        jsonGenerator.writeNumberField("patientAge",drugPrescription.getPatient().getPatientAge());
        jsonGenerator.writeStringField("patientGender", drugPrescription.getPatient().getPatientGender());
        jsonGenerator.writeStringField("patientCountry", drugPrescription.getPatient().getPatientCountry());
        jsonGenerator.writeStringField("patientCounty", drugPrescription.getPatient().getPatientCounty());
        jsonGenerator.writeNumberField("patientPhoneNumber", drugPrescription.getPatient().getPatientPhoneNumber());
        jsonGenerator.writeStringField("patientEmailAddress",drugPrescription.getPatient().getPatientEmailAddress());
        jsonGenerator.writeStringField("patientClinicId", drugPrescription.getPatient().getPatientClinicId());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
