package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.AdoptionRecord;

@Repository
public interface AdoptionRecordRepository extends JpaRepository<AdoptionRecord, Integer>
{

}
