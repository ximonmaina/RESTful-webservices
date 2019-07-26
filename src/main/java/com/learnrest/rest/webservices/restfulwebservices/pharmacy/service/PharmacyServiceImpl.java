package com.learnrest.rest.webservices.restfulwebservices.pharmacy.service;

import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import com.learnrest.rest.webservices.restfulwebservices.pharmacy.data.PharmacyData;
import com.learnrest.rest.webservices.restfulwebservices.pharmacy.domain.Pharmacy;
import com.learnrest.rest.webservices.restfulwebservices.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PharmacyServiceImpl {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Pharmacy savePharmacyData(PharmacyData pharmacyData) {
        Patient patient = this.patientRepository.findPatientById(pharmacyData.getPatient());
        Pharmacy pharmacy = new Pharmacy();

        if (patient != null) {
            pharmacy.setId(pharmacyData.getId());
            pharmacy.setDrugPrescription(pharmacyData.getDrugPrescription());
            pharmacy.setDrugPrescriptionDate(new Date());
            pharmacy.setNameOfDoctor(pharmacyData.getNameOfDoctor());
            pharmacy.setStaffName(pharmacyData.getStaffName());
            pharmacy.setPatient(patient);

            return this.pharmacyRepository.save(pharmacy);
        }

        return null;
    }
}
