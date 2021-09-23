package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository1 extends JpaRepository<Customer, String> 
{

    Optional<Object> findById(Integer customerID);

    void deleteById(Integer customerID);

    boolean existsById(Integer customerID);
}
