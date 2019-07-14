package com.learnrest.rest.webservices.restfulwebservices.laboratory.repository;

import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory , Long> {

    Laboratory findById(long id);
}
