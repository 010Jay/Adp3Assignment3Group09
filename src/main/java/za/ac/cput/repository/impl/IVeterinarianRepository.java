package za.ac.cput.repository.impl;

import za.ac.cput.entity.Dog;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IVeterinarianRepository extends IRepository<Veterinarian, Integer> {

    Set<Veterinarian> getAll();
}