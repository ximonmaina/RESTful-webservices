package com.learnrest.rest.webservices.restfulwebservices.labtestrequest.service;

import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.data.LabTestReqData;
import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.domain.LabTestRequest;
import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.repository.LabTestRequestRepo;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabTestReqServiceImpl {

    @Autowired
    LabTestRequestRepo labTestRequestRepo;

    @Autowired
    PatientRepository patientRepository;

    public LabTestRequest saveLabTestReqData(LabTestReqData labTestReqData) {
        Patient patient = this.patientRepository.findPatientById(labTestReqData.getPatient());
        LabTestRequest labTestRequest = new LabTestRequest();
        if (patient != null) {
            labTestRequest.setTestName(labTestReqData.getTestName());
            labTestRequest.setDateOfRequest(labTestReqData.getDateOfRequest());
            labTestRequest.setDoctorName(labTestReqData.getDoctorName());
            labTestRequest.setPatient(patient);

            return this.labTestRequestRepo.save(labTestRequest);
        }
        return null;
    }

    public LabTestRequest updateLabTestRequestData(LabTestReqData labTestReqData) {
        Patient patient = this.patientRepository.findPatientById(labTestReqData.getPatient());
        LabTestRequest labTestRequest = new LabTestRequest();
        if (patient != null) {
            labTestRequest.setId(labTestReqData.getId());
            labTestRequest.setTestName(labTestReqData.getTestName());
            labTestRequest.setDateOfRequest(labTestReqData.getDateOfRequest());
            labTestRequest.setDoctorName(labTestReqData.getDoctorName());
            labTestRequest.setPatient(patient);

            return this.labTestRequestRepo.save(labTestRequest);
        }
        return null;
    }
}
