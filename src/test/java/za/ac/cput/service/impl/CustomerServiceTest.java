/*CustomerService.java
Service for the CustomerService
Author:Andy William Hine (219259038)
Date:27 July 2021
 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceTest
{
    @Autowired
    private  static CustomerService service = new CustomerService();
    private static Customer customer1 = new CustomerFactory().createCustomer(23456986, "Cameron", "van Wyk", "CVanwyk@gmail.com", "5 virus street", 1298463785);
    private static Customer customer2 = new Customer.Builder().copy(customer1).setCustomerID(6735436).setName("John").setSurname("Booi").setEmailAddress("jBoi@gmail.com").setHomeAddress("10 boem straat").setPhoneNumber(748839495).build();

    @Test
    public void a_create()
    {
        Customer created = service.create(customer1);
        assertEquals(created.getCustomerID(),customer1.getCustomerID());
        System.out.println("Create:" + created);
    }

    @Test
    public void b_read()
    {
        Customer read = service.read(customer1.getCustomerID());
        assertNotEquals(read);
        System.out.println("Read:" + read);
    }

    private void assertNotEquals(Customer read) {
    }

    @Test
    public void c_update()
    {
        Customer update = service.update(customer2);
        assertEquals(4, service.getAll());
        System.out.println("Update: " + update);
    }

    @Test
    public void e_delete()
    {
        boolean delete = service.delete(customer1.getCustomerID());
        assertTrue(delete);
        System.out.println("Delete:" + true);
    }

    @Test
    public void d_getAll()
    {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }


}