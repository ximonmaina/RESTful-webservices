package com.learnrest.rest.webservices.restfulwebservices.patient.service;

import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
     static Integer count = 0;
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

    public Patient savePatient(Patient patient) {
        Patient updatePatient = new Patient();
        if (patient != null) {
            String res1 = patient.getPatientFirstName().substring(0,3).toUpperCase();
            String res2 = patient.getPatientMiddleName().isEmpty() ? "0" : patient.getPatientMiddleName().substring(0, 1).toUpperCase();
            String res3 = patient.getPatientLastName().substring(0, 3).toUpperCase();
            String res4 = res1 + res2 + res3;
            String res5 = count.toString().length() == 1 ? ("00" + count):
                    count.toString().length() == 2 ? ("0" + count): count.toString();
            count = count + 1;
            String finalResult = res4 + res5;
            System.out.println(finalResult);
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
            updatePatient.setPatientClinicId(finalResult);

            return this.patientRepository.save(updatePatient);
        }
        return null;
    }
}
