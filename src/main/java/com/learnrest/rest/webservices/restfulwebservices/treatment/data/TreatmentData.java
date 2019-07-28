package com.learnrest.rest.webservices.restfulwebservices.treatment.data;

import lombok.*;

import java.util.Date;

@Data
public class TreatmentData {

    private long id;
    private String disease;
    private String caseNotes;
    private String staffName;
    private Date dateOfDiagnosis;
    private String drugPrescription;
    private long patient;

    public TreatmentData(long id, String disease, String caseNotes, String staffName,
                         Date dateOfDiagnosis, String drugPrescription, long patient) {
        this.id = id;
        this.disease = disease;
        this.caseNotes = caseNotes;
        this.staffName = staffName;
        this.dateOfDiagnosis = dateOfDiagnosis;
        this.drugPrescription = drugPrescription;
        this.patient = patient;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TreatmentData;
    }

}
