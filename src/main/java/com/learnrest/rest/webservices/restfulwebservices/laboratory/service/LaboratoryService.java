package com.learnrest.rest.webservices.restfulwebservices.laboratory.service;

import com.learnrest.rest.webservices.restfulwebservices.laboratory.data.LaboratoryData;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.repository.LaboratoryRepository;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Laboratory saveLabData(LaboratoryData laboratoryData) {
        Patient patient = this.patientRepository.findPatientById(laboratoryData.getPatient());
        Laboratory laboratory = new Laboratory();

        laboratory.setId(laboratoryData.getId());
        laboratory.setTestName(laboratoryData.getTestName());
        laboratory.setTestResult(laboratoryData.getTestResult());
        laboratory.setTestResultDate(laboratoryData.getTestResultDate());
        laboratory.setStaffName(laboratoryData.getStaffName());
        laboratory.setNameOfDoctor(laboratoryData.getNameOfDoctor());
        laboratory.setPatient(patient);

        return this.laboratoryRepository.save(laboratory);
    }
}
