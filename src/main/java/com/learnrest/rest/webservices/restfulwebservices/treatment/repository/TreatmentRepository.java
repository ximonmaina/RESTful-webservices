package com.learnrest.rest.webservices.restfulwebservices.treatment.repository;

import com.learnrest.rest.webservices.restfulwebservices.treatment.domain.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    Treatment findById(long id);
}
