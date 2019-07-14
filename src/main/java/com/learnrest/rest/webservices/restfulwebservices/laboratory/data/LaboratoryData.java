package com.learnrest.rest.webservices.restfulwebservices.laboratory.data;

import lombok.Data;

import java.util.Date;

@Data
public class LaboratoryData {

    private long id;
    private String testName;
    private String testResult;
    private Date testResultDate;
    private String staffName;
    private String nameOfDoctor;
    private long patient;

    public LaboratoryData(long id, String testName,
                          String testResult, Date testResultDate, String staffName, String nameOfDoctor, long patient) {
        this.id = id;
        this.testName = testName;
        this.testResult = testResult;
        this.testResultDate = testResultDate;
        this.staffName = staffName;
        this.nameOfDoctor = nameOfDoctor;
        this.patient = patient;
    }
}
