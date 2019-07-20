package com.learnrest.rest.webservices.restfulwebservices.pharmacy.data;

import lombok.Data;

import java.util.Date;

@Data
public class PharmacyData {

    private long id;
    private String drugPrescription;
    private Date drugPrescriptionDate;
    private String nameOfDoctor;
    private String staffName;
    private long patient;

    public PharmacyData(long id, String drugPrescription,
                        Date drugPrescriptionDate, String nameOfDoctor, String staffName, long patient) {
        this.id = id;
        this.drugPrescription = drugPrescription;
        this.drugPrescriptionDate = drugPrescriptionDate;
        this.nameOfDoctor = nameOfDoctor;
        this.staffName = staffName;
        this.patient = patient;
    }
}
