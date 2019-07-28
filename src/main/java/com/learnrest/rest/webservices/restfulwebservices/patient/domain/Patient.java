package com.learnrest.rest.webservices.restfulwebservices.patient.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.learnrest.rest.webservices.restfulwebservices.jsonserializers.PatientSerializer;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain.PatientTriage;
import com.learnrest.rest.webservices.restfulwebservices.treatment.domain.Treatment;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonSerialize(using = PatientSerializer.class)
@Entity
@Table(name = "patient")

public class Patient  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "p_fname", nullable = false)
    private String patientFirstName;

    @Column(name = "p_lname", nullable = false)
    private String patientLastName;

    @Column(name = "p_mname")
    private String patientMiddleName;

    @Column(name = "p_id_number")
    private long patientIdentityNumber;

    @Column(name = "p_date_of_birth")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date patientDateOfBirth;

    @Column(name = "p_age")
    private int patientAge;

    @Column(name = "p_gender")
    private String patientGender;

    @Column(name = "p_country")
    private String patientCountry;

    @Column(name = "p_county")
    private String patientCounty;

    @Column(name = "p_phone_number")
    private long patientPhoneNumber;

    @Column(name = "p_address")
    private String patientAddress;

    @Column(name = "p_email_address")
    private String patientEmailAddress;

    @Column(name = "p_join_date")
    private Date patientJoinDate;

    @OneToMany
    @JoinColumn(name = "patient_id")
//    @JsonBackReference
    private Set<PatientTriage> patientTriages = new HashSet<>();


    @OneToMany
    @JoinColumn(name = "patient_id")
    private Set<Treatment> treatments = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    private Set<Laboratory> laboratories = new HashSet<>();

//    @OneToMany
//    @JoinColumn(name = "patient_id")
//    private Set<Pharmacy> pharmacies = new HashSet<>();
//
//    public Set<Pharmacy> getPharmacies() {
//        return pharmacies;
//    }
//
//    public void setPharmacies(Set<Pharmacy> pharmacies) {
//        this.pharmacies = pharmacies;
//    }

    public Set<Laboratory> getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(Set<Laboratory> laboratories) {
        this.laboratories = laboratories;
    }

    public Set<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Treatment> treatments) {
        this.treatments = treatments;
    }

    public Patient() {
    }


    public long getId() {
        return this.id;
    }

    public String getPatientFirstName() {
        return this.patientFirstName;
    }

    public String getPatientLastName() {
        return this.patientLastName;
    }

    public String getPatientMiddleName() {
        return this.patientMiddleName;
    }

    public long getPatientIdentityNumber() {
        return this.patientIdentityNumber;
    }

    public Date getPatientDateOfBirth() {
        return this.patientDateOfBirth;
    }

    public int getPatientAge() {
        return this.patientAge;
    }

    public String getPatientGender() {
        return this.patientGender;
    }

    public String getPatientCountry() {
        return this.patientCountry;
    }

    public String getPatientCounty() {
        return this.patientCounty;
    }

    public long getPatientPhoneNumber() {
        return this.patientPhoneNumber;
    }

    public String getPatientAddress() {
        return this.patientAddress;
    }

    public String getPatientEmailAddress() {
        return this.patientEmailAddress;
    }

    public Date getPatientJoinDate() {
        return this.patientJoinDate;
    }


    public Set<PatientTriage> getPatientTriages() {
        return this.patientTriages;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    public void setPatientIdentityNumber(long patientIdentityNumber) {
        this.patientIdentityNumber = patientIdentityNumber;
    }

    public void setPatientDateOfBirth(Date patientDateOfBirth) {
        this.patientDateOfBirth = patientDateOfBirth;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public void setPatientCountry(String patientCountry) {
        this.patientCountry = patientCountry;
    }

    public void setPatientCounty(String patientCounty) {
        this.patientCounty = patientCounty;
    }

    public void setPatientPhoneNumber(long patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public void setPatientEmailAddress(String patientEmailAddress) {
        this.patientEmailAddress = patientEmailAddress;
    }

    public void setPatientJoinDate(Date patientJoinDate) {
        this.patientJoinDate = patientJoinDate;
    }

    public void setPatientTriages(Set<PatientTriage> patientTriages) {
        this.patientTriages = patientTriages;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", patientMiddleName='" + patientMiddleName + '\'' +
                ", patientIdentityNumber=" + patientIdentityNumber +
                ", patientDateOfBirth=" + patientDateOfBirth +
                ", patientAge=" + patientAge +
                ", patientGender='" + patientGender + '\'' +
                ", patientCountry='" + patientCountry + '\'' +
                ", patientCounty='" + patientCounty + '\'' +
                ", patientPhoneNumber=" + patientPhoneNumber +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientEmailAddress='" + patientEmailAddress + '\'' +
                ", patientJoinDate=" + patientJoinDate +
                ", patientTriages=" + patientTriages +
                ", treatments=" + treatments +
                ", laboratories=" + laboratories +
                '}';
    }
}
