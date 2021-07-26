package za.ac.cput.repository.impl;




import za.ac.cput.entity.DogDescription;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IDogDescriptionRepository extends IRepository<DogDescription, Integer> {


    Set<DogDescription> getAll();
    Integer getSize();
}
