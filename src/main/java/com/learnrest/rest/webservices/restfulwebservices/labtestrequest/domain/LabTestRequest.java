package com.learnrest.rest.webservices.restfulwebservices.labtestrequest.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.learnrest.rest.webservices.restfulwebservices.jsonserializers.LabTestReqSerializer;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonSerialize(using = LabTestReqSerializer.class)
@Entity
@Table(name = "lab_test_request")
public class LabTestRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "date_of_request")
    private Date dateOfRequest;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Patient patient;

    public LabTestRequest() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "LabTestRequest{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                ", dateOfRequest=" + dateOfRequest +
                ", doctorName='" + doctorName + '\'' +
                ", status=" + status +
                ", patient=" + patient +
                '}';
    }
}
