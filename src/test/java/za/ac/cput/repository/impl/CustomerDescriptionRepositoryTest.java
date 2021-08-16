package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.CustomerDescription;
import za.ac.cput.factory.CustomerDescriptionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerDescriptionRepositoryTest
{
    private static CustomerDescriptionRepository repository = new CustomerDescriptionRepository();
    private static CustomerDescription customer = new CustomerDescriptionFactory().createCustomerDescription(123423545);

    @Test
    void a_create() {

        CustomerDescription createCustomer = repository.create(customer);
        System.out.println("Created: " + createCustomer.toString());
        assertEquals(createCustomer.getId(), customer.getId());
    }

    @Test
    void b_read() {

        CustomerDescription readCustomer = repository.read(customer.getId());
        System.out.println("Read: " + readCustomer);
        assertNotNull(readCustomer);
    }

    @Test
    void c_update() {
        CustomerDescription customers = new CustomerDescription.Builder().copy(customer).build();

        customers = repository.update(customers);
        System.out.println("Updated: " + customer.toString());
    }

    @Test
    void e_delete() {

        repository.delete(customer.getId());
        System.out.println("Delete:" + repository);
        assertEquals(0,repository);
    }

    @Test
    void d_getAll() {

        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}