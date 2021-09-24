package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.AdoptionRecord;
import za.ac.cput.repository.AdoptionRecordRepository;

import java.util.Set;
import java.util.stream.Collectors;

/*
    AdoptionRecordService.java
    Adoption Record Service implementation for the Adoption Record entity
    Author: Siyanda Hlongwa (217091229)
    Date: 24 September 2021
 */

@Service
public class AdoptionRecordService implements IAdoptionRecordService
{//start of class

    @Autowired
    private AdoptionRecordRepository repository;
    private static AdoptionRecordService service = null;

    public static AdoptionRecordService getService() {

        if(service == null)
        {
            service = new AdoptionRecordService();
        }

        return service;
    }

    @Override
    public AdoptionRecord create(AdoptionRecord adoptionRecord){return this.repository.save(adoptionRecord);}

    @Override
    public AdoptionRecord read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public AdoptionRecord update(AdoptionRecord adoptionRecord) {
        if(this.repository.existsById(adoptionRecord.getAdoptionId()))
        {
            return this.repository.save(adoptionRecord);
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        this.repository.deleteById(id);

        if(this.repository.existsById(id))
        {
            return false;
        }

        return true;
    }

    @Override
    public Set<AdoptionRecord> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }


}//end of class
