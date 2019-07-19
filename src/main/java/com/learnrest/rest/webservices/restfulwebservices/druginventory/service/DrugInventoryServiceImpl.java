package com.learnrest.rest.webservices.restfulwebservices.druginventory.service;

import com.learnrest.rest.webservices.restfulwebservices.druginventory.domain.DrugInventory;
import com.learnrest.rest.webservices.restfulwebservices.druginventory.repository.DrugInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugInventoryServiceImpl {

    @Autowired
    private DrugInventoryRepository drugInventoryRepository;

    public DrugInventory saveDrugInventory(DrugInventory drugInventory) {
        if (drugInventory != null) {
            return this.drugInventoryRepository.save(drugInventory);
        }
        return null;
    }

    public DrugInventory updateDrugInventory(DrugInventory drugInventory) {
        DrugInventory updateDrugInventory = new DrugInventory();
        if (drugInventory != null) {
            updateDrugInventory.setId(drugInventory.getId());
            updateDrugInventory.setBarCodeId(drugInventory.getBarCodeId());
            updateDrugInventory.setDrugName(drugInventory.getDrugName());
            updateDrugInventory.setUnitPrice(drugInventory.getUnitPrice());
            updateDrugInventory.setSellingPrice(drugInventory.getSellingPrice());
            updateDrugInventory.setInventory(drugInventory.getInventory());
            updateDrugInventory.setExpiryDate(drugInventory.getExpiryDate());
            updateDrugInventory.setManufacturer(drugInventory.getManufacturer());
            updateDrugInventory.setNotes(drugInventory.getNotes());

            return this.drugInventoryRepository.save(updateDrugInventory);
        }
        return null;
    }
}
