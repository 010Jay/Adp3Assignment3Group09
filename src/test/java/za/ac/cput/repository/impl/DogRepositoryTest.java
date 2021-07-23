package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Dog;
import za.ac.cput.factory.DogFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DogRepositoryTest {

    //Attributes
        private static DogRepository repository = new DogRepository();
        private static Dog dog = new DogFactory().createDog("Bimbis", 3, "Golden Brown", false, 'M', "Golden Retriever", 1001, "Vaccinated");
        private static Dog dog2 = new Dog.Builder().copy(dog).setName("Mika").setAge(1).setGender('F').setVetId(1006).build();

    @Test
    void a_create() {

        Dog createDog = repository.create(dog);
        System.out.println("Created: " + createDog.toString());
        assertEquals(createDog.getDogId(), dog.getDogId());
    }

    @Test
    void b_read() {

        Dog readDog = repository.read(dog.getDogId());
        System.out.println("Read: " + readDog);
        assertNotNull(readDog);
    }

    @Test
    void c_update() {

        Dog updateDog = repository.update(dog2);
        assertEquals(1, repository.getSize());
        System.out.println("Updated: " + updateDog.toString());
    }

    @Test
    void e_delete() {

        repository.delete(dog.getDogId());
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