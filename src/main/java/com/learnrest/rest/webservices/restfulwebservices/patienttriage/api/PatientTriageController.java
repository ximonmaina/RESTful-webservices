package com.learnrest.rest.webservices.restfulwebservices.patienttriage.api;

import com.learnrest.rest.webservices.restfulwebservices.patienttriage.PatientData;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain.PatientTriage;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.repository.PatientTriageRepository;
import com.learnrest.rest.webservices.restfulwebservices.patienttriage.service.PatientTriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/patienttriage")
@CrossOrigin("http://localhost:4200")
public class PatientTriageController {
    @Autowired
    PatientTriageRepository patientTriageRepository;

    @Autowired
    PatientTriageService patientTriageService;

    @GetMapping("/getpatienttriage")
    public ResponseEntity<Collection<PatientTriage>> getPatientTriage() {
        return new ResponseEntity<>(patientTriageRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getonepatienttriage/{id}")
    public ResponseEntity<PatientTriage> getOnePatientTriage(@PathVariable long id) {
        PatientTriage getPatientTriage = this.patientTriageRepository.findById(id);

        if (getPatientTriage != null) {
            return new ResponseEntity<>(this.patientTriageRepository.findById(id), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/addPatientTriage")
    public ResponseEntity<Void> createPatientTriage(@RequestBody PatientData patientData) {
        if (patientData != null) {
            PatientTriage createdPatientTriage = this.patientTriageService.savePatientTriage(patientData);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createdPatientTriage.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }
}
