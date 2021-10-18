package za.ac.cput.controller.impl;

/**
 * AdoptionRecordControllerTest.java
 * Test for the AdoptionRecord controller
 * Author: Siyanda Hlongwa (217091229)
 * Date: 16 August 2021
 **/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.AdoptionRecord;
import za.ac.cput.factory.AdoptionRecordFactory;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdoptionRecordControllerTest
{//start of class

    //Attributes
    private static final Date date = new Date();
    private static AdoptionRecord adoptionRecord = new AdoptionRecordFactory().createAdoptionRecord(123, 321, 456, 654, date);
    private AdoptionRecord testAdoptionRecord; //Test purposes

    @Autowired
    private TestRestTemplate restTemplate; // A Rest Template
    private final String BASE_URL = "http://localhost:8080/adoptionRecord";

    @Test
    void a_create() {
        String url = BASE_URL + "/create"; //Url for the create method
        System.out.println("URL: " + url);
        ResponseEntity<AdoptionRecord> postResponse = restTemplate.postForEntity(url, adoptionRecord, AdoptionRecord.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(adoptionRecord.getAdoptionId(), postResponse.getBody().getAdoptionId());
        testAdoptionRecord = postResponse.getBody();
        System.out.println("AdoptionRecord created: " +testAdoptionRecord.toString());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + adoptionRecord.getAdoptionId();
        System.out.println("URL: " + url);
        ResponseEntity<AdoptionRecord> response = restTemplate.getForEntity(url, AdoptionRecord.class);

        assertEquals(adoptionRecord.getAdoptionId(), response.getBody().getAdoptionId());

        testAdoptionRecord = response.getBody();
        System.out.println("Read: " + testAdoptionRecord.toString());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);
        AdoptionRecord updateAdoptionRecord = new AdoptionRecord.Builder().copy(adoptionRecord).setAdoptionId(123).setDogId(987).setCustomerId(789).setStaffId(852).setDate(date).build();
        ResponseEntity<AdoptionRecord> postResponse = restTemplate.postForEntity(url, updateAdoptionRecord, AdoptionRecord.class);

        assertNotNull(postResponse.getBody());

        testAdoptionRecord = postResponse.getBody();
        System.out.println("Record Updated: " + testAdoptionRecord.toString());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + adoptionRecord.toString();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all records:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}//end of class