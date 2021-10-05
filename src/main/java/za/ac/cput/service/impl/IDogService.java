package za.ac.cput.service.impl;

/**
 * IDogService.java
 * Service interface for the Dog entity
 * Author: Jason Jaftha (217009301)
 * Date: 26 July 2021
 **/

import za.ac.cput.entity.Dog;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IDogService extends IService<Dog, Integer> {

    Set<Dog> getAll();
    Integer getSize();
}
