package com.learnrest.rest.webservices.restfulwebservices.drugprescription.data;

import lombok.Data;

import java.util.Date;

@Data
public class DrugPrescData {

    private long id;
    private String drugPrescription;
    private String doctorName;
    private String numberOfDays;
    private String usagePerDay;
    private Date dateOfPrescription;
    private long patient;

    public DrugPrescData(long id, String drugPrescription,
                         String doctorName, String numberOfDays, String usagePerDay,
                         Date dateOfPrescription, long patient) {
        this.id = id;
        this.drugPrescription = drugPrescription;
        this.doctorName = doctorName;
        this.numberOfDays = numberOfDays;
        this.usagePerDay = usagePerDay;
        this.dateOfPrescription = dateOfPrescription;
        this.patient = patient;
    }
}
