package za.ac.cput.repository.impl;

/*
    IDogRepository.java
    Repository Interface for the Dog entity
    Author: Jason Jaftha (217009301)
    Date: 22 July 2021
 */

import za.ac.cput.entity.Dog;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IDogRepository extends IRepository<Dog, Integer> {

    Set<Dog> getAll();
    Integer getSize();
}
