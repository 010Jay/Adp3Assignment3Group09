package za.ac.cput.service.impl;

/*
    DogRepositoryTest.java
    Test class for the Service implementation for the Dog entity.
    Author: Jason Jaftha (217009301)
    Date: 26 July 2021
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Dog;
import za.ac.cput.factory.DogFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class DogServiceTest {
    //Attributes
        @Autowired
        private DogService service = DogService.getService();
        private static Dog dog = new DogFactory().createDog("Bimbis", 3, "Golden Brown", false, 'M', "Golden Retriever", 1001, "Vaccinated");
        private static Dog dog2 = new Dog.Builder().copy(dog).setName("Mika").setAge(1).setGender('F').setVetId(1006).build();

    @Test
    void a_create() {

        Dog createDog = service.create(dog);
        System.out.println("Created: " + createDog.toString());
        System.out.println("Size: " + service.getSize());
        assertEquals(createDog.getDogId(), dog.getDogId());
    }

    @Test
    void b_read() {

        Dog readDog = service.read(dog.getDogId());
        System.out.println("Read: " + readDog);
        assertNotNull(readDog);
    }

    @Test
    void c_update() {

        Dog updateDog = service.update(dog2);
        assertEquals(1, service.getSize());
        System.out.println("Updated: " + updateDog.toString());
    }

    @Disabled
    @Test
    void e_delete() {

        service.delete(dog.getDogId());
        System.out.println("Delete: <size = " + service.getSize() + " >");
        assertEquals(0,service.getSize());
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show all:");
        System.out.println("---------");
        System.out.println(service.getAll());
        System.out.println("---------");
    }
}