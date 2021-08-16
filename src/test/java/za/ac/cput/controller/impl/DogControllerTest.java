package za.ac.cput.controller.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Dog;
import za.ac.cput.factory.DogFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DogControllerTest {

    //Attributes
        private static Dog dog = new DogFactory().createDog("Bimbis", 3, "Golden Brown", false, 'M', "Golden Retriever", 1001, "Vaccinated");
        private Dog testDog; //Test purposes
        @Autowired
        private TestRestTemplate restTemplate; // A Rest Template
        private final String BASE_URL = "http://localhost:8080/dog"; //Base url for dog

    @Test
    void a_create() {
        String url = BASE_URL + "/create"; //Url for the create method
        System.out.println("URL: " + url);
        ResponseEntity<Dog> postResponse = restTemplate.postForEntity(url, dog, Dog.class);

        assertNotNull(postResponse); //Check that the post response is not null.
        assertNotNull(postResponse.getBody()); //Checks that the body of the post response is not null.
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK); //Check that the status code for the post response os successful (200OK).
        assertEquals(dog.getDogId(), postResponse.getBody().getDogId()); //Check that the dog id and the id on the post response matches.

        testDog = postResponse.getBody();
        System.out.println("Dog created: " +testDog.toString());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + dog.getDogId();
        System.out.println("URL: " + url);
        ResponseEntity<Dog> response = restTemplate.getForEntity(url, Dog.class);

        assertEquals(dog.getDogId(), response.getBody().getDogId());

        testDog = response.getBody();
        System.out.println("Read: " + testDog.toString());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);
        Dog updateDog = new Dog.Builder().copy(dog).setName("Mika").setAge(1).setGender('F').setIsPuppy(true).setVetId(1002).build();
        ResponseEntity<Dog> postResponse = restTemplate.postForEntity(url, updateDog, Dog.class);

        assertNotNull(postResponse.getBody());

        testDog = postResponse.getBody();
        System.out.println("Updated: " + testDog.toString());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + dog.getDogId();
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

        System.out.println("Show all dogs:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}