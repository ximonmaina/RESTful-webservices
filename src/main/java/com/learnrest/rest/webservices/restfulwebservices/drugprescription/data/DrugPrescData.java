package com.learnrest.rest.webservices.restfulwebservices.drugprescription.data;

import lombok.Data;

import java.util.Date;

@Data
public class DrugPrescData {

    private long id;
    private String drugName;
    private String drugPrescription;
    private String doctorName;
    private Date dateOfPrescription;
    private long patient;

    public DrugPrescData(long id, String drugName, String drugPrescription, String doctorName,
                         Date dateOfPrescription, long patient) {
        this.id = id;
        this.drugName = drugName;
        this.drugPrescription = drugPrescription;
        this.doctorName = doctorName;
        this.dateOfPrescription = dateOfPrescription;
        this.patient = patient;
    }
}
