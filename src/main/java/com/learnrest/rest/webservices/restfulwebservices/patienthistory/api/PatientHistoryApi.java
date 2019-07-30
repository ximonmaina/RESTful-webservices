package com.learnrest.rest.webservices.restfulwebservices.patienthistory.api;

import com.learnrest.rest.webservices.restfulwebservices.patienthistory.domain.PatientHistory;
import com.learnrest.rest.webservices.restfulwebservices.patienthistory.service.PatientHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patienthistory")
@CrossOrigin("http://localhost:4200")
public class PatientHistoryApi {

    @Autowired
    PatientHistoryServiceImpl patientHistoryService;

    @GetMapping("/getPatientHistory/{id}")
    public ResponseEntity<Collection<PatientHistory>> retrievePatientHistory(@PathVariable long id) {
        Collection<PatientHistory> patientHistories = this.patientHistoryService.retrievePatientHistory(id);
        return new ResponseEntity<>(patientHistories, HttpStatus.OK);
    }
}
