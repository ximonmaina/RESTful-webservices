package com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.data;

import lombok.Data;

@Data
public class TreatmentPatientsData {

    private long id;
    private boolean status;
    private boolean testRequest;
    private String nameOfDoctor;
    private long patient;

    public TreatmentPatientsData(long id, boolean status, boolean testRequest,
                                 String nameOfDoctor, long patient) {
        this.id = id;
        this.status = status;
        this.testRequest = testRequest;
        this.nameOfDoctor = nameOfDoctor;
        this.patient = patient;
    }
}
