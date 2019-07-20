package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.pharmacy.domain.Pharmacy;

import java.io.IOException;

public class PharmacySerializer extends StdSerializer<Pharmacy> {

    public PharmacySerializer() { this( null); }

    public PharmacySerializer(Class<Pharmacy> t) { super(t); }

    @Override
    public void serialize(Pharmacy pharmacy, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", pharmacy.getId());
        jsonGenerator.writeStringField("drugPrescription", pharmacy.getDrugPrescription());
        jsonGenerator.writeObjectField("drugExpiryDate", pharmacy.getDrugPrescriptionDate());
        jsonGenerator.writeStringField("nameOfDoctor", pharmacy.getNameOfDoctor());
        jsonGenerator.writeStringField("staffName", pharmacy.getStaffName());
        jsonGenerator.writeArrayFieldStart("patient");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", pharmacy.getPatient().getId());
        jsonGenerator.writeStringField("patientFirstName", pharmacy.getPatient().getPatientFirstName());
        jsonGenerator.writeStringField("patientLastName", pharmacy.getPatient().getPatientLastName());
        jsonGenerator.writeStringField("patientMiddleName", pharmacy.getPatient().getPatientMiddleName());
        jsonGenerator.writeNumberField("patientIdentityNumber",pharmacy.getPatient().getPatientIdentityNumber());
        jsonGenerator.writeObjectField("patientDateOfBirth",pharmacy.getPatient().getPatientDateOfBirth());
        jsonGenerator.writeNumberField("patientAge",pharmacy.getPatient().getPatientAge());
        jsonGenerator.writeStringField("patientGender", pharmacy.getPatient().getPatientGender());
        jsonGenerator.writeStringField("patientCountry", pharmacy.getPatient().getPatientCountry());
        jsonGenerator.writeStringField("patientCounty", pharmacy.getPatient().getPatientCounty());
        jsonGenerator.writeNumberField("patientPhoneNumber", pharmacy.getPatient().getPatientPhoneNumber());
        jsonGenerator.writeStringField("patientEmailAddress",pharmacy.getPatient().getPatientEmailAddress());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();

    }
}
