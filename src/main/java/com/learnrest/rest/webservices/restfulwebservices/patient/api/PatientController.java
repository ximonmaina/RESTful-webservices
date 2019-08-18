package com.learnrest.rest.webservices.restfulwebservices.patient.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import com.learnrest.rest.webservices.restfulwebservices.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@CrossOrigin("http://localhost:4200")
public class PatientController {
    private PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    private PatientService patientService;

    @GetMapping("/getpatients")
    public ResponseEntity<Collection<Patient>> getAllPatients() {
        return new ResponseEntity<>(this.patientRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping("/getpatient/{id}")
    public Patient getPatient(@PathVariable long id) {
        Optional<Patient> findPatient = this.patientRepository.findById(id);

        if (findPatient.isPresent()) {
            return findPatient.get();
        }

        return null;
    }

    @PostMapping("/addpatient")
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient) {
        if (patient != null) {
            patient.setPatientJoinDate(new Date());
            Patient createdPatient =  this.patientService.savePatient(patient);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createdPatient.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }

    @PatchMapping("/updatepatient")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
            Patient updatePatient= this.patientService.updatePatient(patient);
            return new ResponseEntity<Patient>(updatePatient, HttpStatus.OK);


    }

}
