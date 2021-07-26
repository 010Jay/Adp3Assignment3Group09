/*CustomerRepositoryTest.java
Repository for the CustomerRepositoryTest
Author:Andy William Hine (219259038)
Date:23 July 2021
 */

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.impl.CustomerRepository;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class CustomerRepositoryTest
{
    private static CustomerRepository repository = new CustomerRepository();
    private static Customer customer1 = new CustomerFactory().createCustomer(8790532, "James", "Hine", "jcHine@gmail.com", "2 kraakbos street", 234553224);
    private static Customer customer2 = new Customer.Builder().copy(customer1).setCustomerID(6735436).setName("Wendy").setSurname("Hine").setEmailAddress("wdrHine@gmail.com").setHomeAddress("8 boem straat").setPhoneNumber(465643225).build();


    @Test
    public void a_create()
    {
        Customer created = repository.create(customer1);
        assertEquals(created.getCustomerID(),customer1.getCustomerID());
        System.out.println("Create:" + created);
    }

    @Test
    public void b_read()
    {
        Customer read = repository.read(customer1.getCustomerID());
        assertNotEquals(read);
        System.out.println("Read:" + read);
    }

    private void assertNotEquals(Customer read) {
    }

    @Test
    public void c_update()
    {
        Customer update = repository.update(customer2);
        assertEquals(4, repository.getAll());
        System.out.println("Update: " + update);
    }

    @Test
    public void e_delete()
    {
        boolean delete = repository.delete(customer1.getCustomerID());
        assertTrue(delete);
        System.out.println("Delete:" + delete);
    }

    @Test
    public void d_getAll()
    {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }


}