package com.learnrest.rest.webservices.restfulwebservices.drugprescription.api;

import com.learnrest.rest.webservices.restfulwebservices.drugprescription.data.DrugPrescData;
import com.learnrest.rest.webservices.restfulwebservices.drugprescription.domain.DrugPrescription;
import com.learnrest.rest.webservices.restfulwebservices.drugprescription.repository.DrugPrescRepo;
import com.learnrest.rest.webservices.restfulwebservices.drugprescription.service.DrugPrescServiceImpl;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/drugprescription")
@CrossOrigin("http://localhost:4200")
public class DrugPrescriptionController {

    @Autowired
    private DrugPrescRepo drugPrescRepo;

    @Autowired
    private DrugPrescServiceImpl drugPrescService;


    @GetMapping("/getAllDrugPrescriptions")
    public ResponseEntity<Collection<DrugPrescription>> getAllDrugPresc() {
        return new ResponseEntity<>(this.drugPrescRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getDrugPresc/{id}")
    public ResponseEntity<DrugPrescription> getDrugPresc(@PathVariable long id) {
        DrugPrescription drugPrescription = this.drugPrescRepo.findById(id);

        if (drugPrescription != null) {
            return new ResponseEntity<>(this.drugPrescRepo.findById(id), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addDrugPresc")
    public ResponseEntity<Void> addDrugPrescription(@RequestBody DrugPrescData drugPrescData) {
        if (drugPrescData!= null) {
            DrugPrescription drugPrescription = this.drugPrescService.saveDrugPrescriptionData(drugPrescData);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(drugPrescription.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }

    @PatchMapping("/updateDrugPresc")
    public ResponseEntity<DrugPrescription> update(@RequestBody DrugPrescData drugPrescData) {

        DrugPrescription drugPrescription = this.drugPrescService.updateDrugPrescriptionData(drugPrescData);
        return new ResponseEntity<>(drugPrescription, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDrugPresc/{id}")
    public ResponseEntity<Void> deleteDrugPrescription(@PathVariable long id) {
        this.drugPrescRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
