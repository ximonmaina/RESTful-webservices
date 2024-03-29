package com.learnrest.rest.webservices.restfulwebservices.patient.api;

import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
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
import java.util.Date;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientControllerTest {


  @Autowired
  private TestRestTemplate restTemplate;

  @LocalServerPort
  int randomServerPort;


    @Test
   public void whenValidUrlAndMethodAndContentType_thenReturns200() throws Exception {

        Patient patient = new Patient("Sylvia", "Wangari","Wanjeri", 12345678, new Date(),  22, "Male","Kenya","Kiambu", 623413423, "776-00290", "maina@gmail.com", new Date(), "SLYWANGWANJ006");

        final String baseUrl = "http://localhost:"+randomServerPort+"/patient/addpatient";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", TokenString.TOKEN_STRING.getTokenString());
        HttpEntity<Patient> request = new HttpEntity<>(patient, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(201, result.getStatusCodeValue());

    }


    @Test
   public void whenValidInput_thenReturnsUserResource() throws Exception {
        Patient patient = new Patient("Sylvia", "Wangari","Wanjeri", 12345678, new Date(),
                22, "Male","Kenya","Kiambu", 623413423, "776-00290",
                "maina@gmail.com", new Date(), "SLYWANGWANJ006");

        final String baseUrl = "http://localhost:"+randomServerPort+"/patient/getpatient/1";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", TokenString.TOKEN_STRING.getTokenString());

        HttpEntity<Patient> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("patientFirstName"));



    }

    @Test
   public void whenNullValue_thenReturns400AndErrorResult() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/patient/getpatient/1";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Patient> requestEntity = new HttpEntity<>(null, headers);

        try {
            restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
            Assert.fail();
        } catch (HttpClientErrorException ex) {
            // Verify bad request and missing header
            Assert.assertEquals(401, ex.getRawStatusCode());
            Assert.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
        }


    }

}