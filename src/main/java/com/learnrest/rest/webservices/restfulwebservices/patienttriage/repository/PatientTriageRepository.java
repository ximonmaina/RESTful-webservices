package com.learnrest.rest.webservices.restfulwebservices.patienttriage.repository;

import com.learnrest.rest.webservices.restfulwebservices.patienttriage.domain.PatientTriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTriageRepository  extends JpaRepository<PatientTriage, Long> {
   PatientTriage findById(long id);
}
