package com.learnrest.rest.webservices.restfulwebservices.patient.service;

import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient updatePatient(Patient patient) {
        Patient updatePatient = new Patient();
        if (patient != null) {
            updatePatient.setId(patient.getId());
            updatePatient.setPatientFirstName(patient.getPatientFirstName());
            updatePatient.setPatientLastName(patient.getPatientLastName());
            updatePatient.setPatientMiddleName(patient.getPatientMiddleName());
            updatePatient.setPatientIdentityNumber(patient.getPatientIdentityNumber());
            updatePatient.setPatientDateOfBirth(patient.getPatientDateOfBirth());
            updatePatient.setPatientAge(patient.getPatientAge());
            updatePatient.setPatientGender(patient.getPatientGender());
            updatePatient.setPatientCountry(patient.getPatientCountry());
            updatePatient.setPatientCounty(patient.getPatientCounty());
            updatePatient.setPatientPhoneNumber(patient.getPatientPhoneNumber());
            updatePatient.setPatientAddress(patient.getPatientAddress());
            updatePatient.setPatientEmailAddress(patient.getPatientEmailAddress());

            return this.patientRepository.save(updatePatient);
        }
        return null;
    }
}
