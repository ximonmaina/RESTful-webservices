package com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.learnrest.rest.webservices.restfulwebservices.jsonserializers.PatientTriageSerializer;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonSerialize(using = PatientTriageSerializer.class)
@Entity
@Table(name = "patient_triage")
public class PatientTriage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pt_weight")
    private double patientWeight;

    @Column(name = "pt_temp")
    private double patientTemperature;

    @Column(name = "pt_height")
    private double patinetHeight;

    @Column(name = "pt_blood_pressure")
    private String patientBloodPressure;

    @Column(name = "pt_staff_name")
    private String staffName;

    @Column(name = "triage_date")
    private Date triageDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JsonManagedReference
    private Patient patient;

    public PatientTriage() {
    }

    public long getId() {
        return this.id;
    }

    public double getPatientWeight() {
        return this.patientWeight;
    }

    public double getPatientTemperature() {
        return this.patientTemperature;
    }

    public double getPatinetHeight() {
        return this.patinetHeight;
    }

    public String getPatientBloodPressure() {
        return this.patientBloodPressure;
    }

    public String getStaffName() {
        return this.staffName;
    }


    public Patient getPatient() {
        return this.patient;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPatientWeight(double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public void setPatientTemperature(double patientTemperature) {
        this.patientTemperature = patientTemperature;
    }

    public void setPatinetHeight(double patinetHeight) {
        this.patinetHeight = patinetHeight;
    }

    public void setPatientBloodPressure(String patientBloodPressure) {
        this.patientBloodPressure = patientBloodPressure;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getTriageDate() {
        return triageDate;
    }

    public void setTriageDate(Date triageDate) {
        this.triageDate = triageDate;
    }

    @Override
    public String toString() {
        return "PatientTriage{" +
                "id=" + id +
                ", patientWeight=" + patientWeight +
                ", patientTemperature=" + patientTemperature +
                ", patinetHeight=" + patinetHeight +
                ", patientBloodPressure='" + patientBloodPressure + '\'' +
                ", staffName='" + staffName + '\'' +
                ", triageDate=" + triageDate +
                ", patient=" + patient +
                '}';
    }
}
