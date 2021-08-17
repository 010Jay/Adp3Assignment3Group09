package za.ac.cput.controller.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CustomerControllerTest
{
    private static Customer customer = CustomerFactory.createCustomer(895954834, "Chester", "Edwards", "CEddie@gmail.com", "28 Onyx street", 846363485);
    private Customer customerTest;
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/customer";


    @Test
    void a_create()
    {
        String url = BASE_URL+"/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url,customer,Customer.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        // assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
         assertEquals(customer.getCustomerID(),postResponse.getBody().getCustomerID());

        customerTest = postResponse.getBody();
        System.out.println("Saved data:" + customerTest.toString());

    }


    @Test
    void b_read()
    {
        String url = BASE_URL + "/read/" + customer.getCustomerID();
        System.out.println("URL:" +url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url,Customer.class);
        assertEquals(customer.getCustomerID(), response.getBody().getCustomerID());
        customerTest = response.getBody();
        System.out.println("Read: " + customerTest.toString());
    }

    @Test
    void c_update()
    {
        Customer updated = new Customer.Builder().copy(customer).setCustomerID(12234455).setName("Justin").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url,updated,Customer.class);
        assertNotNull(response.getBody());

        customerTest = response.getBody();
        System.out.println("update:" + customerTest.toString());

    }

    @Test
    void e_delete()
    {
        String url = BASE_URL + "/delete" + customer.getCustomerID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}