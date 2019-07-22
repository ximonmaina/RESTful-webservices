package com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.service;

import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import com.learnrest.rest.webservices.restfulwebservices.treatment.data.TreatmentData;
import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.data.TreatmentPatientsData;
import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.domain.TreatmentPatients;
import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.repository.TreatmentPatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreatmentPatientsServiceImpl {

    @Autowired
    private TreatmentPatientsRepository treatmentPatientsRepository;

    @Autowired
    private PatientRepository patientRepository;

    public TreatmentPatients saveTreatmentPatients(TreatmentPatientsData treatmentPatientsData) {
        Patient patient = this.patientRepository.findPatientById(treatmentPatientsData.getPatient());

        TreatmentPatients treatmentPatients = new TreatmentPatients();
        if (patient != null) {
            treatmentPatients.setStatus(treatmentPatientsData.isStatus());
            treatmentPatients.setTestResult(treatmentPatientsData.isTestRequest());
            treatmentPatients.setNameOfDoctor(treatmentPatientsData.getNameOfDoctor());
            treatmentPatients.setPatient(patient);
            return this.treatmentPatientsRepository.save(treatmentPatients);
        }
        return null;
    }

    public TreatmentPatients updateTreatmentPatients(TreatmentPatientsData treatmentPatientsData) {
        Patient patient = this.patientRepository.findPatientById(treatmentPatientsData.getPatient());

        TreatmentPatients updateTreatmentPatients = new TreatmentPatients();
        if (patient != null) {
            updateTreatmentPatients.setId(treatmentPatientsData.getId());
            updateTreatmentPatients.setStatus(treatmentPatientsData.isStatus());
            updateTreatmentPatients.setTestResult(treatmentPatientsData.isTestRequest());
            updateTreatmentPatients.setNameOfDoctor(treatmentPatientsData.getNameOfDoctor());
            updateTreatmentPatients.setPatient(patient);
            return this.treatmentPatientsRepository.save(updateTreatmentPatients);
        }
        return null;
    }
}
