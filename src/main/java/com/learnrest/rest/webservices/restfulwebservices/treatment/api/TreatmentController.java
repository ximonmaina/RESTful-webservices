package com.learnrest.rest.webservices.restfulwebservices.treatment.api;

import com.learnrest.rest.webservices.restfulwebservices.treatment.data.TreatmentData;
import com.learnrest.rest.webservices.restfulwebservices.treatment.domain.Treatment;
import com.learnrest.rest.webservices.restfulwebservices.treatment.repository.TreatmentRepository;
import com.learnrest.rest.webservices.restfulwebservices.treatment.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/treatment")
@CrossOrigin("http://localhost:4200")
public class TreatmentController {

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/getAllTreatmentData")
    public ResponseEntity<Collection<Treatment>> getPatientTreatmentData() {
        return new ResponseEntity<>(treatmentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getTreatmentData/{id}")
    public ResponseEntity<Treatment> getTreatmentData(@PathVariable long id) {
        Treatment getPatientTreatmentData = this.treatmentRepository.findById(id);

        if (getPatientTreatmentData != null) {
            return new ResponseEntity<>(this.treatmentRepository.findById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addPatientTreatmentData")
    public ResponseEntity<Void> createPatientTreatmentData(@RequestBody TreatmentData treatmentData) {
        if (treatmentData != null) {
            Treatment createTreatmentData = this.treatmentService.saveTreatmentData(treatmentData);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createTreatmentData.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }
}
