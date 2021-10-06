package za.ac.cput.service.impl;

/**
 * DogService.java
 * Dog Service implementation for the Dog entity
 * Author: Jason Jaftha (217009301)
 * Date: 26 July 2021
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Dog;
import za.ac.cput.repository.DogRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service //Indicating to spring boot that this class is a service
public class DogService implements IDogService {

    //Attributes
        @Autowired
        private DogRepository repository;
        private static DogService service = null;

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
        return this.repository.save(dog);
    }

    @Override
    public Dog read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Dog update(Dog dog) {
        if(this.repository.existsById(dog.getDogId()))
        {
            return this.repository.save(dog);
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        this.repository.deleteById(id);

        if(this.repository.existsById(id))
        {
            return false;
        }

        return true;
    }

    @Override
    public Set<Dog> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Integer getSize() {
        return repository.findAll().stream().collect(Collectors.toSet()).size();
    }
}
