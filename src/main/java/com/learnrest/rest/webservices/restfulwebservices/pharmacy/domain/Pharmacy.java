package com.learnrest.rest.webservices.restfulwebservices.pharmacy.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.learnrest.rest.webservices.restfulwebservices.jsonserializers.PharmacySerializer;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonSerialize(using = PharmacySerializer.class)
@Entity
@Table(name = "pharmacy")
public class Pharmacy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "drug_prescription", columnDefinition = "TEXT")
    private String drugPrescription;

    @Column(name = "drug_prescription_date")
    private Date drugPrescriptionDate;

    @Column(name = "name_of_doctor")
    private String nameOfDoctor;

    @Column(name = "staff_name")
    private String staffName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Patient patient;

    public Pharmacy() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrugPrescription() {
        return drugPrescription;
    }

    public void setDrugPrescription(String drugPrescription) {
        this.drugPrescription = drugPrescription;
    }

    public Date getDrugPrescriptionDate() {
        return drugPrescriptionDate;
    }

    public void setDrugPrescriptionDate(Date drugPrescriptionDate) {
        this.drugPrescriptionDate = drugPrescriptionDate;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getNameOfDoctor() {
        return nameOfDoctor;
    }

    public void setNameOfDoctor(String nameOfDoctor) {
        this.nameOfDoctor = nameOfDoctor;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", drugPrescription='" + drugPrescription + '\'' +
                ", drugPrescriptionDate=" + drugPrescriptionDate +
                ", nameOfDoctor='" + nameOfDoctor + '\'' +
                ", staffName='" + staffName + '\'' +
                ", patient=" + patient +
                '}';
    }
}
