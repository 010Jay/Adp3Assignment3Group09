package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.DogDescription;
import za.ac.cput.factory.DogDescriptionFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DogDescriptionRepositoryTest {

    //Attributes
    private static DogDescriptionRepository repository = new DogDescriptionRepository();
    private static DogDescription dog = new DogDescriptionFactory().createDogDescription(12, "dog");


    @Test
    void a_create() {

        DogDescription createDog = repository.create(dog);
        System.out.println("Created: " + createDog.toString());
        assertEquals(createDog.getId(), dog.getId());
    }

    @Test
    void b_read() {

        DogDescription readDog = repository.read(dog.getId());
        System.out.println("Read: " + readDog);
        assertNotNull(readDog);
    }

    @Test
    void c_update() {
        DogDescription dogs = new DogDescription.Builder().copy(dog).setType("Dog").build();

        dogs = repository.update(dogs);
        System.out.println("Updated: " + dogs.toString());
    }

    @Test
    void e_delete() {

        repository.delete(dog.getId());
        System.out.println("Delete: <size = " + repository.getSize() + " >");
        assertEquals(0,repository.getSize());
    }

    @Test
    void d_getAll() {

        System.out.println("Show all:");
        System.out.println("---------");
        System.out.println(repository.getAll());
        System.out.println("---------");
    }
}


