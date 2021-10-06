package za.ac.cput.controller.impl;

/**
 * StaffControllerTest.java
 * Test for the Staff controller
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 **/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StaffControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/staff";
    private static Staff staff = StaffFactory.createStaff(10, "Jon", "Snow");

    @Test
    void a_create() {
        String url = BASE_URL + "/create"; //Url for the create method
        System.out.println("URL: " + url);
        ResponseEntity<Staff> postResponse = restTemplate.postForEntity(url, staff, Staff.class);

        assertEquals(postResponse.getStatusCode(), HttpStatus.OK); //Check that the status code for the post response os successful (200OK).
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + staff.getStaffId();
        System.out.println("URL: " + url);
        ResponseEntity<Staff> response = restTemplate.getForEntity(url, Staff.class);

        assertEquals(staff.getStaffId(), response.getBody().getStaffId());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);
        Staff updateStaff = new Staff.Builder().copy(staff).setName("Demon").setSurname("Salvatore").build();
        ResponseEntity<Staff> postResponse = restTemplate.postForEntity(url, updateStaff, Staff.class);

        assertNotNull(postResponse.getBody());
    }

    @Disabled
    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + staff.getStaffId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() { //Getting a list of dog objects and returning it as string type | that way no need to loop through to display the list?? | Return header info as well
        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all Staffs:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}