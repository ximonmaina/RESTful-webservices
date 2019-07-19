package com.learnrest.rest.webservices.restfulwebservices.druginventory.repository;

import com.learnrest.rest.webservices.restfulwebservices.druginventory.domain.DrugInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugInventoryRepository extends JpaRepository<DrugInventory, Long> {

    DrugInventory findById(long id);
}
