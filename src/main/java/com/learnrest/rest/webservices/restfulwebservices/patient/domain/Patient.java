package com.learnrest.rest.webservices.restfulwebservices.patient.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain.PatientTriage;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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

//    @OneToMany(mappedBy = "patient")
//    private Set<PatientTriage> patientTriages = new HashSet<>();



}
