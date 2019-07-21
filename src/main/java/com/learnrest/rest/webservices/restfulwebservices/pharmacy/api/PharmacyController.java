package com.learnrest.rest.webservices.restfulwebservices.pharmacy.api;

import com.learnrest.rest.webservices.restfulwebservices.pharmacy.data.PharmacyData;
import com.learnrest.rest.webservices.restfulwebservices.pharmacy.domain.Pharmacy;
import com.learnrest.rest.webservices.restfulwebservices.pharmacy.repository.PharmacyRepository;
import com.learnrest.rest.webservices.restfulwebservices.pharmacy.service.PharmacyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/pharmacy")
@CrossOrigin("http://localhost:4200")
public class PharmacyController {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    PharmacyServiceImpl pharmacyService;

    @GetMapping("/getAllPharmacyData")
    public ResponseEntity<Collection<Pharmacy>> getPharmacyData() {
        return new ResponseEntity<>(this.pharmacyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getPharmacyData/{id}")
    public  ResponseEntity<Pharmacy> getPharmData(@PathVariable long id) {
        Pharmacy pharmacy = this.pharmacyRepository.findById(id);

        if (pharmacy != null) {
            return new ResponseEntity<>(this.pharmacyRepository.findById(id), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addPharmData")
    public ResponseEntity<Void> addPharmacyData(@RequestBody PharmacyData pharmacyData) {
        if (pharmacyData != null) {
            Pharmacy pharmacy = this.pharmacyService.savePharmacyData(pharmacyData);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(pharmacy.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }
}
