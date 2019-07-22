package com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.api;

import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.data.TreatmentPatientsData;
import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.domain.TreatmentPatients;
import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.repository.TreatmentPatientsRepository;
import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.service.TreatmentPatientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/treatmentpatients")
@CrossOrigin("http://localhost:4200")
public class TreatmentPatientsController {

    @Autowired
    private TreatmentPatientsRepository treatmentPatientsRepository;

    @Autowired
    private TreatmentPatientsServiceImpl treatmentPatientsService;

    @GetMapping("/getAllTreatmentPatients")
    public ResponseEntity<Collection<TreatmentPatients>> getAllTreatPatients() {
        return new ResponseEntity<>(this.treatmentPatientsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getTreatmentPatients/{id}")
    public ResponseEntity<TreatmentPatients> getDrugPresc(@PathVariable long id) {
        TreatmentPatients treatmentPatients = this.treatmentPatientsRepository.findById(id);

        if (treatmentPatients != null) {
            return new ResponseEntity<>(this.treatmentPatientsRepository.findById(id), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addTreatmentPatients")
    public ResponseEntity<Void> addDrugPrescription(@RequestBody TreatmentPatientsData treatmentPatientsData) {
        if (treatmentPatientsData!= null) {
            TreatmentPatients treatmentPatients = this.treatmentPatientsService.saveTreatmentPatients(treatmentPatientsData);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(treatmentPatients.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }

    @PatchMapping("/updateTreatmentPatients")
    public ResponseEntity<TreatmentPatients> update(@RequestBody TreatmentPatientsData treatmentPatientsData) {

        TreatmentPatients treatmentPatients = this.treatmentPatientsService.updateTreatmentPatients(treatmentPatientsData);
        return new ResponseEntity<>(treatmentPatients, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTreatmentPatients/{id}")
    public ResponseEntity<Void> deleteDrugPrescription(@PathVariable long id) {
        this.treatmentPatientsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
