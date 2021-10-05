package za.ac.cput.factory;

/**
 * DogFactoryTest.java
 * Test class for the DogFactory class
 * Author: Jason Jaftha (217009301)
 * Date: 05 June 2021
 **/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Dog;

import static org.junit.jupiter.api.Assertions.*;

class DogFactoryTest {

    //Attributes
        Dog dog1, dog2;

    @BeforeEach
    void setUp() {

        dog1 = new DogFactory().createDog("Mika", 1, "Golden Brown", true, 'F', "Golden Retriever", 1006, "Vaccinated");
        dog2 = new DogFactory().createDog("Bimbis", 3, "Golden Brown", false, 'M', "Golden Retriever", 1001, "Vaccinated");
    }

    @Timeout(5) //Timeout test

    @Test
    public void testCreateDog()
    {
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
    }

    @Test
    public void testEquality()
    {
        assertNotEquals(dog1, dog2);
    }

    @Test
    public void testIdentity()
    {
        assertNotSame(dog1, dog2);
    }

    @Disabled("Test case not implemented!")
    @Test
    public void testBuilder()
    {
        System.out.println("...");
    }

}