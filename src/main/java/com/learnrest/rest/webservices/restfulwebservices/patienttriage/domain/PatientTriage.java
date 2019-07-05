package com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
