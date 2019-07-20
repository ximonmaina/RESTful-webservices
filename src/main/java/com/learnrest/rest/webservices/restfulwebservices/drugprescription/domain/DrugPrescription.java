package com.learnrest.rest.webservices.restfulwebservices.drugprescription.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.learnrest.rest.webservices.restfulwebservices.jsonserializers.DrugPrescriptionSerializer;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonSerialize(using = DrugPrescriptionSerializer.class)
@Entity
@Table(name = "drug_prescription")
public class DrugPrescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "drug_prescription", columnDefinition = "TEXT")
    private String drugPrescription;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "date_of_prescription")
    private Date dateOfPrescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Patient patient;

    public DrugPrescription() {
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDateOfPrescription() {
        return dateOfPrescription;
    }

    public void setDateOfPrescription(Date dateOfPrescription) {
        this.dateOfPrescription = dateOfPrescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "DrugPrescription{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", drugPrescription='" + drugPrescription + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", dateOfPrescription=" + dateOfPrescription +
                ", patient=" + patient +
                '}';
    }
}
