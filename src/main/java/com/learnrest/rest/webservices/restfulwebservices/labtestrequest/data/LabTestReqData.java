package com.learnrest.rest.webservices.restfulwebservices.labtestrequest.data;

import lombok.Data;

import java.util.Date;

@Data
public class LabTestReqData {

    private long id;
    private String testName;
    private Date dateOfRequest;
    private String doctorName;
    private boolean status;
    private long patient;

    public LabTestReqData(long id, String testName, Date dateOfRequest,
                          String doctorName, boolean status, long patient) {
        this.id = id;
        this.testName = testName;
        this.dateOfRequest = dateOfRequest;
        this.doctorName = doctorName;
        this.status = status;
        this.patient = patient;
    }
}
