package za.ac.cput.service.impl;

/*
    IDogService.java
    Dog Service implementation for the Dog entity
    Author: Jason Jaftha (217009301)
    Date: 26 July 2021
 */

import za.ac.cput.entity.Dog;
import za.ac.cput.repository.impl.DogRepository;

import java.util.Set;

public class DogService implements IDogService {

    //Attributes
        private static DogService service = null;
        private DogRepository repository;

    //Constructor
        public DogService() {

            this.repository = new DogRepository();
        }

    //Singleton
        public static DogService getService() {

            if(service == null)
            {
                service = new DogService();
            }

            return service;
        }

    @Override
    public Dog create(Dog dog) {
        return this.repository.create(dog);
    }

    @Override
    public Dog read(Integer integer) {
        return this.repository.read(integer);
    }

    @Override
    public Dog update(Dog dog) {
        return this.repository.update(dog);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.repository.delete(integer);
    }

    @Override
    public Set<Dog> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Integer getSize() {
        return this.repository.getSize();
    }
}
