package com.learnrest.rest.webservices.restfulwebservices.patienttriage;

import lombok.Data;

@Data
public class PatientData {

    private long id;

    private double patientWeight;

    private double patientTemperature;

    private double patientHeight;

    private String patientBloodPressure;

    private String staffName;

    private long patient;

    public PatientData(long id, double patientWeight, double patientTemperature, double patientHeight, String patientBloodPressure, String staffName, long patient) {
        this.id = id;
        this.patientWeight = patientWeight;
        this.patientTemperature = patientTemperature;
        this.patientHeight = patientHeight;
        this.patientBloodPressure = patientBloodPressure;
        this.staffName = staffName;
        this.patient = patient;
    }
}
