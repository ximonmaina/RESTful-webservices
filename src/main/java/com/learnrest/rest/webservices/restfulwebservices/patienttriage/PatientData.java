package com.learnrest.rest.webservices.restfulwebservices.patienttriage;

import lombok.Data;

@Data
public class PatientData {

    private long id;

    private double patientWeight;

    private double patientTemperature;

    private double patinetHeight;

    private String patientBloodPressure;

    private long patient;

    public PatientData(long id, double patientWeight, double patientTemperature, double patinetHeight, String patientBloodPressure, long patient) {
        this.id = id;
        this.patientWeight = patientWeight;
        this.patientTemperature = patientTemperature;
        this.patinetHeight = patinetHeight;
        this.patientBloodPressure = patientBloodPressure;
        this.patient = patient;
    }
}
