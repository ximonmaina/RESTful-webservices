package com.learnrest.rest.webservices.restfulwebservices.patienttriage.service;

import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.PatientData;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain.PatientTriage;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.repository.PatientTriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientTriageService {

    @Autowired
    private PatientTriageRepository patientTriageRepository;

    @Autowired
    private PatientRepository patientRepository;

    public PatientTriage savePatientTriage(PatientData patientData) {
        Patient patient = this.patientRepository.findPatientById(patientData.getPatient());
        PatientTriage patientTriage = new PatientTriage();

        patientTriage.setId(patientData.getId());
        patientTriage.setPatientWeight(patientData.getPatientWeight());
        patientTriage.setPatientTemperature(patientData.getPatientTemperature());
        patientTriage.setPatinetHeight(patientData.getPatinetHeight());
        patientTriage.setPatientBloodPressure(patientData.getPatientBloodPressure());
        patientTriage.setPatient(patient);

        return this.patientTriageRepository.save(patientTriage);

    }


}
