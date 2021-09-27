package za.ac.cput.repository;
/*
    VeterinarianRepository.java
    Author: Nonhlahla Hlungwani (218160658)

 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Veterinarian;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Integer> {
}
