package com.learnrest.rest.webservices.restfulwebservices.treatment.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.learnrest.rest.webservices.restfulwebservices.jsonserializers.TreatmentSerializer;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonSerialize(using = TreatmentSerializer.class)
@Entity
@Table(name = "treatment")
public class Treatment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "t_disease")
    private String disease;

    @Column(name = "t_notes", columnDefinition = "TEXT")
    private String caseNotes;

    @Column(name = "t_staff_name")
    private String staffName;

    @Column(name = "date_of_diagnosis")
    private Date dateOfDiagnosis;

    @Column(name = "drug_prescription", columnDefinition = "TEXT")
    private String drugPrescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Patient patient;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "treatment_laboratory",
    joinColumns = {@JoinColumn(name="treatment_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "laboratory_id", referencedColumnName = "id")}
    )
    private Set<Laboratory> laboratories = new HashSet<>();

    public Treatment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getCaseNotes() {
        return caseNotes;
    }

    public void setCaseNotes(String caseNotes) {
        this.caseNotes = caseNotes;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getDateOfDiagnosis() {
        return dateOfDiagnosis;
    }

    public void setDateOfDiagnosis(Date dateOfDiagnosis) {
        this.dateOfDiagnosis = dateOfDiagnosis;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDrugPrescription() {
        return drugPrescription;
    }

    public void setDrugPrescription(String drugPrescription) {
        this.drugPrescription = drugPrescription;
    }

    public Set<Laboratory> getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(Set<Laboratory> laboratories) {
        this.laboratories = laboratories;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id=" + id +
                ", disease='" + disease + '\'' +
                ", caseNotes='" + caseNotes + '\'' +
                ", staffName='" + staffName + '\'' +
                ", dateOfDiagnosis=" + dateOfDiagnosis +
                ", drugPrescription='" + drugPrescription + '\'' +
                ", patient=" + patient +
                '}';
    }
}
