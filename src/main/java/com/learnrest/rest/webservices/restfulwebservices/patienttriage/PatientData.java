package com.learnrest.rest.webservices.restfulwebservices.patienttriage;

import lombok.Data;

import java.util.Date;

@Data
public class PatientData {

    private long id;

    private double patientWeight;

    private double patientTemperature;

    private double patientHeight;

    private String patientBloodPressure;

    private String staffName;

    private Date triageDate;

    private long patient;

    public PatientData(long id, double patientWeight, double patientTemperature, double patientHeight,
                       String patientBloodPressure, String staffName, Date triageDate, long patient) {
        this.id = id;
        this.patientWeight = patientWeight;
        this.patientTemperature = patientTemperature;
        this.patientHeight = patientHeight;
        this.patientBloodPressure = patientBloodPressure;
        this.staffName = staffName;
        this.triageDate = triageDate;
        this.patient = patient;
    }
}
