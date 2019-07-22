package com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.learnrest.rest.webservices.restfulwebservices.jsonserializers.TreatmentPatientSerializer;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;

@JsonSerialize(using = TreatmentPatientSerializer.class)
@Entity
@Table(name = "treatment_patients")
public class TreatmentPatients implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status")
    private boolean status;

    @Column(name = "test_result")
    private boolean testResult;

    @Column(name = "name_of_doctor")
    private String nameOfDoctor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Patient patient;

    public TreatmentPatients() {
    }

    public boolean isTestResult() {
        return testResult;
    }

    public void setTestResult(boolean testResult) {
        this.testResult = testResult;
    }

    public String getNameOfDoctor() {
        return nameOfDoctor;
    }

    public void setNameOfDoctor(String nameOfDoctor) {
        this.nameOfDoctor = nameOfDoctor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "TreatmentPatients{" +
                "id=" + id +
                ", status=" + status +
                ", testResult=" + testResult +
                ", nameOfDoctor='" + nameOfDoctor + '\'' +
                ", patient=" + patient +
                '}';
    }
}
