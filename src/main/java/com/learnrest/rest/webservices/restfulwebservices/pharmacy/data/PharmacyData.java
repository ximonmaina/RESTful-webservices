package com.learnrest.rest.webservices.restfulwebservices.pharmacy.data;

import lombok.Data;

import java.util.Date;

@Data
public class PharmacyData {

    private long id;
    private String drugName;
    private String drugDosage;
    private String drugNotes;
    private Date drugExpiryDate;
    private String nameOfDoctor;
    private String staffName;
    private long patient;

    public PharmacyData(long id, String drugName, String drugDosage,
                        String drugNotes, Date drugExpiryDate, String nameOfDoctor,
                        String staffName, long patient) {
        this.id = id;
        this.drugName = drugName;
        this.drugDosage = drugDosage;
        this.drugNotes = drugNotes;
        this.drugExpiryDate = drugExpiryDate;
        this.nameOfDoctor = nameOfDoctor;
        this.staffName = staffName;
        this.patient = patient;
    }
}
