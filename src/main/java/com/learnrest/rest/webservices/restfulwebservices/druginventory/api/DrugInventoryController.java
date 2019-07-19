package com.learnrest.rest.webservices.restfulwebservices.druginventory.api;

import com.learnrest.rest.webservices.restfulwebservices.druginventory.domain.DrugInventory;
import com.learnrest.rest.webservices.restfulwebservices.druginventory.repository.DrugInventoryRepository;
import com.learnrest.rest.webservices.restfulwebservices.druginventory.service.DrugInventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/drug-inventory")
@CrossOrigin("http://localhost:4200")
public class DrugInventoryController {

    @Autowired
    DrugInventoryRepository drugInventoryRepository;

    @Autowired
    DrugInventoryServiceImpl drugInventoryService;

    @GetMapping("/getAllDrugs")
    public ResponseEntity<Collection<DrugInventory>> getDrugsInventory() {
        return new ResponseEntity<>(this.drugInventoryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getDrugInventory/{id}")
    public ResponseEntity<DrugInventory> getDrugInv(@PathVariable long id) {
        DrugInventory drugInventory = this.drugInventoryRepository.findById(id);

        if (drugInventory != null) {
            return new ResponseEntity<>(drugInventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping("/addDrugInventory")
    public ResponseEntity<Void> createDrugInve(@RequestBody DrugInventory drugInventory) {
        if (drugInventory != null) {
            DrugInventory drugInventory1 = this.drugInventoryService.saveDrugInventory(drugInventory);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(drugInventory1.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return null;
    }

    @PatchMapping("/updateDrugInv")
    public ResponseEntity<DrugInventory> updateDrugInv(@RequestBody DrugInventory drugInventory) {
        DrugInventory updatedDrugInv = this.drugInventoryService.updateDrugInventory(drugInventory);
        return new ResponseEntity<DrugInventory>(updatedDrugInv, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDrugInv/{id}")
    public ResponseEntity<Void> deleteDrugInv(@PathVariable long id) {
        this.drugInventoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
