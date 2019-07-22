package com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.repository;

import com.learnrest.rest.webservices.restfulwebservices.treatmentpatients.domain.TreatmentPatients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentPatientsRepository extends JpaRepository<TreatmentPatients, Long> {

    TreatmentPatients findById(long id);
}
