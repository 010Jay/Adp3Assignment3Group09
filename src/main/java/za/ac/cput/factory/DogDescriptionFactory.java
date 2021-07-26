package za.ac.cput.factory;

/*
    DogDescriptionFactoryTest.java
    Test class for the DogDescriptionFactory class
    Author: Sinoxolo Jaca
    Date: 06 June 2021
 */

import za.ac.cput.entity.DogDescription;

public class DogDescriptionFactory {




        public static DogDescription createDogDescription(int id, String type) {
            return new DogDescription.Builder()
                    .setId(id)
                    .setType(type)
                    .build();

        }
}
