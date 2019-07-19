package com.learnrest.rest.webservices.restfulwebservices.laboratory.domain;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.learnrest.rest.webservices.restfulwebservices.jsonserializers.LaboratorySerializer;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonSerialize(using = LaboratorySerializer.class)
@Entity
@Table(name = "laboratory")
public class Laboratory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_result", columnDefinition = "TEXT")
    private String testResult;

    @Column(name = "test_result_date")
    private Date testResultDate;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "name_of_doctor")
    private String nameOfDoctor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Patient patient;

    public Laboratory() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Date getTestResultDate() {
        return testResultDate;
    }

    public void setTestResultDate(Date testResultDate) {
        this.testResultDate = testResultDate;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getNameOfDoctor() {
        return nameOfDoctor;
    }

    public void setNameOfDoctor(String nameOfDoctor) {
        this.nameOfDoctor = nameOfDoctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                ", testResult='" + testResult + '\'' +
                ", testResultDate=" + testResultDate +
                ", staffName='" + staffName + '\'' +
                ", nameOfDoctor='" + nameOfDoctor + '\'' +
                ", patient=" + patient +
                '}';
    }
}
