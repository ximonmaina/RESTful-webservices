package com.learnrest.rest.webservices.restfulwebservices.drugprescription.repository;

import com.learnrest.rest.webservices.restfulwebservices.drugprescription.domain.DrugPrescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugPrescRepo extends JpaRepository<DrugPrescription, Long> {

    DrugPrescription findById(long id);
}
