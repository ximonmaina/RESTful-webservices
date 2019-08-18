package com.learnrest.rest.webservices.restfulwebservices.laboratory.api;

import com.learnrest.rest.webservices.restfulwebservices.laboratory.data.LaboratoryData;
import com.learnrest.rest.webservices.restfulwebservices.laboratory.domain.Laboratory;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.repository.PatientRepository;
import com.learnrest.rest.webservices.restfulwebservices.tokenstringconstants.TokenString;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaboratoryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void whenValidUrlAndContentType_thenResturns200() throws URISyntaxException {
        LaboratoryData laboratory = new LaboratoryData(0, "Typhoid test name",
                "Negative for typhoid test", new Date(), "kariuki", "Maina", 1);


        final String baseUrl = "http://localhost:"+randomServerPort+"/laboratory/addLabData";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", TokenString.TOKEN_STRING.getTokenString());
        HttpEntity<LaboratoryData> request = new HttpEntity<>(laboratory, headers);
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    public void whenValidInput_thenReturnResource() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/laboratory/getLabData/1";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", TokenString.TOKEN_STRING.getTokenString());
        HttpEntity<Laboratory> request = new HttpEntity<>(null, headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("testName"));

    }

    @Test
    public void whenNullHeaderValue_thenReturns400AndErrorResult() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/laboratory/getLabData/1";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Laboratory> requestEntity = new HttpEntity<>(null, headers);

        try {
            restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
            Assert.fail();
        } catch (HttpClientErrorException ex) {
            Assert.assertEquals(401, ex.getRawStatusCode());
            Assert.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
        }
    }

}