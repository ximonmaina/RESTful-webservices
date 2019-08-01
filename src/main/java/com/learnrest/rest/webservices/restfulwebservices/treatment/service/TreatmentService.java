package com.learnrest.rest.webservices.restfulwebservices.treatment.service;

import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.repository.LaboratoryRepository;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import com.learnrest.rest.webservices.restfulwebservices.treatment.data.TreatmentData;
import com.learnrest.rest.webservices.restfulwebservices.treatment.domain.Treatment;
import com.learnrest.rest.webservices.restfulwebservices.treatment.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public Treatment saveTreatmentData(TreatmentData treatmentData) {


        if (treatmentData.getLaboratoryId() != -1) {
            Patient patient = this.patientRepository.findPatientById(treatmentData.getPatient());
            Laboratory laboratory = this.laboratoryRepository.findById(treatmentData.getLaboratoryId());
            Treatment treatment = new Treatment();

            treatment.setId(treatmentData.getId());
            treatment.setDisease(treatmentData.getDisease());
            treatment.setCaseNotes(treatmentData.getCaseNotes());
            treatment.setStaffName(treatmentData.getStaffName());
            treatment.setDateOfDiagnosis(treatmentData.getDateOfDiagnosis());
            treatment.setDrugPrescription(treatmentData.getDrugPrescription());
            treatment.setPatient(patient);
            treatment.getLaboratories().add(laboratory);

            return this.treatmentRepository.save(treatment);
        } else if (treatmentData.getLaboratoryId() == -1) {
            Patient patient = this.patientRepository.findPatientById(treatmentData.getPatient());
            Laboratory newLab = new Laboratory();
            newLab.setTestName("no tests were done");
            newLab.setTestResult("no tests were done");
            newLab.setTestResultDate(new Date());
            newLab.setStaffName("no tests were done");
            newLab.setNameOfDoctor("no tests were done");
            newLab.setPatient(patient);
            Laboratory getSavedLabData = this.laboratoryRepository.save(newLab);
            Treatment treatment = new Treatment();

            treatment.setId(treatmentData.getId());
            treatment.setDisease(treatmentData.getDisease());
            treatment.setCaseNotes(treatmentData.getCaseNotes());
            treatment.setStaffName(treatmentData.getStaffName());
            treatment.setDateOfDiagnosis(treatmentData.getDateOfDiagnosis());
            treatment.setDrugPrescription(treatmentData.getDrugPrescription());
            treatment.setPatient(patient);
            treatment.getLaboratories().add(getSavedLabData);

            return this.treatmentRepository.save(treatment);
        }
        return null;


    }
}
