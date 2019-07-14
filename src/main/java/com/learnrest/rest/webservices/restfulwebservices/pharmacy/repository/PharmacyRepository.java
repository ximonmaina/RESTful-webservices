package com.learnrest.rest.webservices.restfulwebservices.pharmacy.repository;

import com.learnrest.rest.webservices.restfulwebservices.pharmacy.domain.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    Pharmacy findById(long id);
}
