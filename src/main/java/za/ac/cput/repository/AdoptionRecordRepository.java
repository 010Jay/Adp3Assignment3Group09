package za.ac.cput.repository;

/**
 * AdoptionRecordRepository.java
 * Repository for the AdoptionRecord entity
 * Author: Siyanda Hlongwa (217091229)
 * Date: 30 August 2021
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.AdoptionRecord;

@Repository
public interface AdoptionRecordRepository extends JpaRepository<AdoptionRecord, Integer>
{

}
