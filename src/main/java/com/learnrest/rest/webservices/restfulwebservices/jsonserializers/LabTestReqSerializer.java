package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.domain.LabTestRequest;

import java.io.IOException;

public class LabTestReqSerializer extends StdSerializer<LabTestRequest> {

    public LabTestReqSerializer() { this(null);}

    public LabTestReqSerializer(Class<LabTestRequest> t) { super(t);}

    @Override
    public void serialize(LabTestRequest labTestRequest, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", labTestRequest.getId());
        jsonGenerator.writeStringField("testName", labTestRequest.getTestName());
        jsonGenerator.writeObjectField("dateOfRequest", labTestRequest.getDateOfRequest());
        jsonGenerator.writeStringField("doctorName", labTestRequest.getDoctorName());
        jsonGenerator.writeBooleanField("status", labTestRequest.isStatus());
        jsonGenerator.writeArrayFieldStart("patient");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", labTestRequest.getPatient().getId());
        jsonGenerator.writeStringField("patientFirstName", labTestRequest.getPatient().getPatientFirstName());
        jsonGenerator.writeStringField("patientLastName", labTestRequest.getPatient().getPatientLastName());
        jsonGenerator.writeStringField("patientMiddleName", labTestRequest.getPatient().getPatientMiddleName());
        jsonGenerator.writeNumberField("patientIdentityNumber",labTestRequest.getPatient().getPatientIdentityNumber());
        jsonGenerator.writeObjectField("patientDateOfBirth",labTestRequest.getPatient().getPatientDateOfBirth());
        jsonGenerator.writeNumberField("patientAge",labTestRequest.getPatient().getPatientAge());
        jsonGenerator.writeStringField("patientGender", labTestRequest.getPatient().getPatientGender());
        jsonGenerator.writeStringField("patientCountry", labTestRequest.getPatient().getPatientCountry());
        jsonGenerator.writeStringField("patientCounty", labTestRequest.getPatient().getPatientCounty());
        jsonGenerator.writeNumberField("patientPhoneNumber", labTestRequest.getPatient().getPatientPhoneNumber());
        jsonGenerator.writeStringField("patientEmailAddress",labTestRequest.getPatient().getPatientEmailAddress());
        jsonGenerator.writeStringField("patientClinicId", labTestRequest.getPatient().getPatientClinicId());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
