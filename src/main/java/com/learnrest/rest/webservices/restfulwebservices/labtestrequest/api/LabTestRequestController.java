package com.learnrest.rest.webservices.restfulwebservices.labtestrequest.api;

import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.data.LabTestReqData;
import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.domain.LabTestRequest;
import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.repository.LabTestRequestRepo;
import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.service.LabTestReqServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/labrequest")
@CrossOrigin("http://localhost:4200")
public class LabTestRequestController {

    @Autowired
    private LabTestRequestRepo labTestRequestRepo;

    @Autowired
    private LabTestReqServiceImpl labTestReqService;

    @GetMapping("/getAllLabTestReq")
    public ResponseEntity<Collection<LabTestRequest>> getAllLabTestRequests() {
        return new ResponseEntity<>(this.labTestRequestRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getLabTestReq/{id}")
    public ResponseEntity<LabTestRequest> getLabTestReq(@PathVariable long id) {
        LabTestRequest labTestRequest = this.labTestRequestRepo.findById(id);

        if (labTestRequest != null) {
            return new ResponseEntity<>(this.labTestRequestRepo.findById(id), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addLabTestReq")
    public ResponseEntity<Void> addLabTestRequest(@RequestBody LabTestReqData labTestReqData) {
        if (labTestReqData != null) {
            LabTestRequest labTestRequest = this.labTestReqService.saveLabTestReqData(labTestReqData);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(labTestRequest.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }

    @PatchMapping("/updateLabTestRequest")
    public ResponseEntity<LabTestRequest> update(@RequestBody LabTestReqData labTestReqData) {
        LabTestRequest labTestRequest = this.labTestReqService.updateLabTestRequestData(labTestReqData);
        return new ResponseEntity<>(labTestRequest, HttpStatus.OK);
    }

    @DeleteMapping("/deleteLabRequest/{id}")
    public ResponseEntity<Void> deleteLabReq(@PathVariable long id) {
        this.labTestRequestRepo.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
