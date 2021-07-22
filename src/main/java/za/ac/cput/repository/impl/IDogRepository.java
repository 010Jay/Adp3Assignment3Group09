package za.ac.cput.repository.impl;

import za.ac.cput.entity.Dog;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IDogRepository extends IRepository<Dog, Integer> {

    Set<Dog> getAll();
}
