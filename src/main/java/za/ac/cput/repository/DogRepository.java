package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Dog;

//No Sql needed, everything is provided by the JpaRepository class

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

}
