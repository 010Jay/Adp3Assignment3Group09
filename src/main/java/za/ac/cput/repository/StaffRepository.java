package za.ac.cput.repository;

/**
 * StaffRepository.java
 * Repository for the Staff entity
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
