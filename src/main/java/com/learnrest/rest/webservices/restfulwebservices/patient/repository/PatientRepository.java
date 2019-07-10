package com.learnrest.rest.webservices.restfulwebservices.patient.repository;

import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findById(long id);

    Patient findPatientById(long id);


}
