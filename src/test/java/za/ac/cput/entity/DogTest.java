package za.ac.cput.entity;

/*
    DogTest.java
    Test Case for the Dog
    Author: Jason Jaftha (217009301)
    Date: 03 June 2021
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DogTest {

    //Attributes
        Dog dog1, dog2;

    @BeforeEach
    void setUp() {

        dog1 = new Dog.Builder().setDogId(7).setName("Bimbis").setAge(3).setColor("Golden Brown").setIsPuppy(false).setGender('M').setBreed("Golden Retriever").setVetId(1001).setVaccinationStatus("Vaccinated").build();
        dog2 = new Dog.Builder().copy(dog1).setDogId(10).setName("Mika").setAge(1).setIsPuppy(true).setGender('F').setVetId(1006).build();
    }

    @Test
    public void testDog()
    {
        System.out.println("dog1: " + dog1.toString());
        System.out.println("dog2: " + dog2.toString());
    }
}