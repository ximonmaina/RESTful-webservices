package com.learnrest.rest.webservices.restfulwebservices.laboratory.api;

import com.learnrest.rest.webservices.restfulwebservices.laboratory.data.LaboratoryData;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.repository.LaboratoryRepository;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/laboratory")
@CrossOrigin("http://localhost:4200")
public class LaboratoryController {

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @Autowired
    LaboratoryService laboratoryService;

    @GetMapping("/getAllLabData")
    public ResponseEntity<Collection<Laboratory>> getPatientLabData() {
        return new ResponseEntity<>(this.laboratoryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getLabData/{id}")
    public ResponseEntity<Laboratory> getLabData(@PathVariable long id) {
        Laboratory getPatientLabData = this.laboratoryRepository.findById(id);

        if (getPatientLabData != null) {
            return new ResponseEntity<>(this.laboratoryRepository.findById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addLabData")
    public ResponseEntity<Void> createPatientLabData(@RequestBody LaboratoryData laboratoryData) {
        if (laboratoryData != null) {
            Laboratory createLabData = this.laboratoryService.saveLabData(laboratoryData);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(createLabData.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }
}
