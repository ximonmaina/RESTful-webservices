package com.learnrest.rest.webservices.restfulwebservices.labtestrequest.data;

import lombok.Data;

import java.util.Date;

@Data
public class LabTestReqData {

    private long id;
    private String testName;
    private Date dateOfRequest;
    private String doctorName;
    private long patient;

    public LabTestReqData(long id, String testName, Date dateOfRequest, String doctorName, long patient) {
        this.id = id;
        this.testName = testName;
        this.dateOfRequest = dateOfRequest;
        this.doctorName = doctorName;
        this.patient = patient;
    }
}
