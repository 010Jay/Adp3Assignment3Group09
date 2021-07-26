package za.ac.cput.repository.impl;

/*
    DogRepository.java
    Dog Repository implementation for the Dog entity.
    Author: Jason Jaftha (217009301)
    Date: 22 July 2021
 */

import za.ac.cput.entity.Dog;

import java.util.HashSet;
import java.util.Set;

public class DogRepository implements IDogRepository {

    //Attributes
        private static DogRepository repository = null;
        private Set<Dog> dogDB;

    //Constructor
        public DogRepository()
        {
            this.dogDB = new HashSet<>();
        }

   //Singleton
        public static DogRepository getRepository()
        {
            if(repository == null)
            {
                repository = new DogRepository();
            }

            return repository;
        }

    @Override
    public Dog create(Dog dog) {

        this.dogDB.add(dog);

        return dog;
    }

    @Override
    public Dog read(Integer id) {

         Dog dog = null;


         for(Dog d: dogDB)
         {
             if(id.equals(d.getDogId()))
             {
                 dog = d;
                 break;
             }
         }

         return dog;
    }

    @Override
    public Dog update(Dog dog) {

         Dog oldDog = read(dog.getDogId());

         if(oldDog != null)
         {
             dogDB.remove(oldDog);
             dogDB.add(dog);

             return dog;
         }

         return null;
    }

    @Override
    public boolean delete(Integer id) {

        Dog dog = read(id);

        if(dog != null)
        {
            dogDB.remove(dog);
            return true;
        }

        return false;
    }

    @Override
    public Set<Dog> getAll() {
        return dogDB;
    }

    @Override
    public Integer getSize() {
        return dogDB.size();
    }
}
