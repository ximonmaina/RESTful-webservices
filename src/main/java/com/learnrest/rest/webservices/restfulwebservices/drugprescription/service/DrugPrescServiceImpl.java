package com.learnrest.rest.webservices.restfulwebservices.drugprescription.service;

import com.learnrest.rest.webservices.restfulwebservices.drugprescription.data.DrugPrescData;
import com.learnrest.rest.webservices.restfulwebservices.drugprescription.domain.DrugPrescription;
import com.learnrest.rest.webservices.restfulwebservices.drugprescription.repository.DrugPrescRepo;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugPrescServiceImpl {

    @Autowired
    private DrugPrescRepo drugPrescRepo;

    @Autowired
    private PatientRepository patientRepository;

    public DrugPrescription saveDrugPrescriptionData(DrugPrescData drugPrescData) {
        Patient patient = this.patientRepository.findPatientById(drugPrescData.getPatient());

        DrugPrescription drugPrescription = new DrugPrescription();
        if (patient != null) {
            drugPrescription.setDrugPrescription(drugPrescData.getDrugPrescription());
            drugPrescription.setDoctorName(drugPrescData.getDoctorName());
            drugPrescription.setNumberOfDays(drugPrescData.getNumberOfDays());
            drugPrescription.setUsagePerDay(drugPrescData.getUsagePerDay());
            drugPrescription.setDateOfPrescription(drugPrescData.getDateOfPrescription());
            drugPrescription.setPatient(patient);
            return this.drugPrescRepo.save(drugPrescription);
        }
        return null;
    }

    public DrugPrescription updateDrugPrescriptionData(DrugPrescData drugPrescData) {
        Patient patient = this.patientRepository.findPatientById(drugPrescData.getPatient());
        DrugPrescription updateDrugPrescription = new DrugPrescription();

        updateDrugPrescription.setId(drugPrescData.getId());
        updateDrugPrescription.setDrugPrescription(drugPrescData.getDrugPrescription());
        updateDrugPrescription.setDoctorName(drugPrescData.getDoctorName());
        updateDrugPrescription.setNumberOfDays(drugPrescData.getNumberOfDays());
        updateDrugPrescription.setUsagePerDay(drugPrescData.getUsagePerDay());
        updateDrugPrescription.setDateOfPrescription(drugPrescData.getDateOfPrescription());
        updateDrugPrescription.setPatient(patient);

        return this.drugPrescRepo.save(updateDrugPrescription);
    }

}
