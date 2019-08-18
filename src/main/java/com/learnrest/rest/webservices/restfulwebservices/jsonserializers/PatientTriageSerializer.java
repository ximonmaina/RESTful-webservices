package com.learnrest.rest.webservices.restfulwebservices.jsonserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain.PatientTriage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class PatientTriageSerializer extends StdSerializer<PatientTriage> {

    public PatientTriageSerializer() {
        this(null);
    }



    public PatientTriageSerializer(Class<PatientTriage> t) {
        super(t);
    }

    @Override
    public void serialize(PatientTriage patientTriage, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {


        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", patientTriage.getId());
        jsonGenerator.writeNumberField("patientWeight", patientTriage.getPatientWeight());
        jsonGenerator.writeNumberField("patientTemperature", patientTriage.getPatientTemperature());
        jsonGenerator.writeNumberField("patientHeight", patientTriage.getPatinetHeight());
        jsonGenerator.writeStringField("patientBloodPressure", patientTriage.getPatientBloodPressure());
        jsonGenerator.writeStringField("staffName", patientTriage.getStaffName());
        jsonGenerator.writeObjectField("triageDate", patientTriage.getTriageDate());
        jsonGenerator.writeArrayFieldStart("patient");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", patientTriage.getPatient().getId());
        jsonGenerator.writeStringField("patientFirstName", patientTriage.getPatient().getPatientFirstName());
        jsonGenerator.writeStringField("patientLastName", patientTriage.getPatient().getPatientLastName());
        jsonGenerator.writeStringField("patientMiddleName", patientTriage.getPatient().getPatientMiddleName());
        jsonGenerator.writeNumberField("patientIdentityNumber",patientTriage.getPatient().getPatientIdentityNumber());
        jsonGenerator.writeObjectField("patientDateOfBirth",patientTriage.getPatient().getPatientDateOfBirth());
        jsonGenerator.writeNumberField("patientAge",patientTriage.getPatient().getPatientAge());
        jsonGenerator.writeStringField("patientGender", patientTriage.getPatient().getPatientGender());
        jsonGenerator.writeStringField("patientCountry", patientTriage.getPatient().getPatientCountry());
        jsonGenerator.writeStringField("patientCounty", patientTriage.getPatient().getPatientCounty());
        jsonGenerator.writeNumberField("patientPhoneNumber", patientTriage.getPatient().getPatientPhoneNumber());
        jsonGenerator.writeStringField("patientEmailAddress",patientTriage.getPatient().getPatientEmailAddress());
        jsonGenerator.writeStringField("patientClinicId", patientTriage.getPatient().getPatientClinicId());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();


    }
}
