package za.ac.cput.repository;

/**
 * DogRepository.java
 * Repository for the Dog entity
 * Author: Jason Jaftha (217009301)
 * Date: 30 August 2021
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Dog;

//No Sql needed, everything is provided by the JpaRepository class

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

}
