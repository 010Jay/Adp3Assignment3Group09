package za.ac.cput.factory;

/**
 * DogFactory.java
 * DogFactory class for the Dog entity
 * Author: Jason Jaftha (217009301)
 * Date: 05 June 2021
 **/

import za.ac.cput.entity.Dog;

public class DogFactory {

    //Attributes
        private static int id = 0;

    public Dog createDog(String name, int age, String color, boolean isPuppy, char gender, String breed, int vetId, String vaccinationStatus)
    {
        return new Dog.Builder()
                .setDogId(++id)
                .setName(name)
                .setAge(age)
                .setColor(color)
                .setIsPuppy(isPuppy)
                .setGender(gender)
                .setBreed(breed)
                .setVetId(vetId)
                .setVaccinationStatus(vaccinationStatus)
                .build();
    }
}
