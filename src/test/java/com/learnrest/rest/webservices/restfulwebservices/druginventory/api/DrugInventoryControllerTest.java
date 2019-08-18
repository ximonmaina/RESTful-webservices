package com.learnrest.rest.webservices.restfulwebservices.druginventory.api;

import com.learnrest.rest.webservices.restfulwebservices.druginventory.domain.DrugInventory;
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
public class DrugInventoryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testAddDrugInventory() throws URISyntaxException {

        final String baseUrl = "http://localhost:"+randomServerPort+"/drug-inventory/addDrugInventory";
        URI uri = new URI(baseUrl);
        DrugInventory drugInventory = new DrugInventory();
        drugInventory.setBarCodeId(122234343);
        drugInventory.setDrugName("Chloroquin");
        drugInventory.setUnitPrice(25);
        drugInventory.setSellingPrice(40);
        drugInventory.setInventory(2000);
        drugInventory.setExpiryDate(new Date());
        drugInventory.setManufacturer("Privy");
        drugInventory.setNotes("In Stock");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", TokenString.TOKEN_STRING.getTokenString());
        HttpEntity<DrugInventory> request = new HttpEntity<>(drugInventory, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(201, result.getStatusCodeValue());
    }

    @Test
    public void testGetDrugInventorySuccessWithHeaders() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:"+randomServerPort+"/drug-inventory/getDrugInventory/1";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", TokenString.TOKEN_STRING.getTokenString());

        HttpEntity<DrugInventory> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("drugName"));

    }

    @Test
    public void testDrugInventoryFailWithoutHeaders() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/drug-inventory/getDrugInventory/1";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<DrugInventory> requestEntity = new HttpEntity<>(null, headers);

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