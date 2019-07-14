package com.learnrest.rest.webservices.restfulwebservices.labtestrequest.repository;

import com.learnrest.rest.webservices.restfulwebservices.labtestrequest.domain.LabTestRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRequestRepo extends JpaRepository<LabTestRequest, Long> {

    LabTestRequest findById(long id);
}
