package za.ac.cput.Factory;

/*
    DogDescriptionFactoryTest.java
    Test class for the DogDescriptionFactory class
    Author: Sinoxolo Jaca
    Date: 06 June 2021
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.DogDescription;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DogDescriptionFactoryTest {

    @Test
    public void createDogDescription() {

        DogDescription dogDescription = DogDescriptionFactory.createDogDescription(78378, "dog");

        Assertions.assertEquals("dog", dogDescription.getType());
        Assertions.assertNotEquals(9889, dogDescription.getId());
    }

    @Disabled("DogDesc")


    @Test
    void DogDescription() {

        //This will pass
        Assertions.assertTimeout(Duration.ofMinutes(2), () ->{
            return "result";

        });

        //This will fail
        Assertions.assertTimeout(Duration.ofMillis(1),() -> {
            Thread.sleep(5);
            return "result";
        });
    }



}