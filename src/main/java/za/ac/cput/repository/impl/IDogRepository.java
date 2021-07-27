package za.ac.cput.repository.impl;

/*
    DogDescriptionRepository.java
    Repository Interface for the Dog entity
    Author: Sinoxolo Jaca

 */

import za.ac.cput.entity.Dog;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IDogRepository extends IRepository<Dog, Integer> {

    Set<Dog> getAll();
    Integer getSize();
}
