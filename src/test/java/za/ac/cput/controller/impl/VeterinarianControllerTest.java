package za.ac.cput.controller.impl;
/*
    VeterinarianControllerTest.java
    Author: Nonhlahla Hlungwani (218160658)
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.factory.VeterinarianFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VeterinarianControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/veterinarian";
    private Veterinarian vet2,vetTest,updateVet;
    private Veterinarian vet = new VeterinarianFactory().createVeterinarian("Nonhlahla", "Hlungwani", 0720657472, "218160658@mycput.ac.za");

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Veterinarian> postResponse = restTemplate.postForEntity(url, vet, Veterinarian.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(vet.getVetId(), postResponse.getBody().getVetId());
        System.out.println(vet.toString());
        vetTest = postResponse.getBody();
        System.out.println("Create: " +vetTest.toString());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + vet.getVetId();
        ResponseEntity<Veterinarian> response = restTemplate.getForEntity(url, Veterinarian.class);
        assertEquals(vet.getVetId(), response.getBody().getVetId());
        vetTest  = response.getBody();
        System.out.println("Read: " + vetTest.toString());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update/";
        vet2 = new Veterinarian.Builder().copy(vet).setName("Mandla").setSurname("Hlungwani").setPhoneNumber(277345632).setEmailAddress("233767890@mycput.ac.za").build();
        ResponseEntity<Veterinarian> postResponse = restTemplate.postForEntity(url, vet2, Veterinarian.class);
        assertNotNull(postResponse.getBody());
        vetTest = postResponse.getBody();
        System.out.println("Update: " + vetTest.toString());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + vet.getVetId();
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getAll" ;
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}