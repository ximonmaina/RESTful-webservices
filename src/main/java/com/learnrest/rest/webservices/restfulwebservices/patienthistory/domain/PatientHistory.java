package com.learnrest.rest.webservices.restfulwebservices.patienthistory.domain;

import lombok.Data;

import java.util.Date;

@Data
public class PatientHistory {

    // Patient
    private String patientFirstName;
    private String patientLastName;
    private String patientMiddleName;
    private int patientAge;
    private String patientGender;

    // triage data
    private double patientWeight;
    private double patientTemperature;
    private double patientHeight;
    private String patientBloodPressure;
    private String nurseName;
    private Date triageDate;

    // treatment
    private String disease;
    private String caseNotes;
    private String doctorName;
    private String drugPrescription;

    // laboratory
    private String testName;
    private String testResult;
    private String labTechName;

    public PatientHistory(String patientFirstName, String patientLastName, String patientMiddleName, int patientAge, String patientGender, double patientWeight,
                          double patientTemperature, double patientHeight, String patientBloodPressure,
                          String nurseName, Date triageDate, String disease, String caseNotes, String doctorName, String drugPrescription, String testName, String testResult, String labTechName) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientMiddleName = patientMiddleName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientWeight = patientWeight;
        this.patientTemperature = patientTemperature;
        this.patientHeight = patientHeight;
        this.patientBloodPressure = patientBloodPressure;
        this.nurseName = nurseName;
        this.triageDate = triageDate;
        this.disease = disease;
        this.caseNotes = caseNotes;
        this.doctorName = doctorName;
        this.drugPrescription = drugPrescription;
        this.testName = testName;
        this.testResult = testResult;
        this.labTechName = labTechName;
    }
}
