package za.ac.cput.service.impl;
/*
    VeterinarianService.java
    Author: Nonhlahla Hlungwani (218160658)
    Date: 02 August 2021
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.repository.VeterinarianRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VeterinarianService implements IVeterinarianService {
    @Autowired
    private VeterinarianRepository repository;
    private static VeterinarianService service=null;

    public VeterinarianService(VeterinarianRepository repository) {
        this.repository = repository;
    }

    public VeterinarianService() {

    }

    public static VeterinarianService getService() {
        if(service==null) service= new VeterinarianService();

        return service;
    }

    @Override
    public Veterinarian create(Veterinarian veterinarian)
    {
        return this.repository.save(veterinarian);
    }

    @Override
    public Veterinarian read(Integer vetId)
    {
        return this.repository.findById(vetId).orElse(null);
    }
    @Override
    public Veterinarian update(Veterinarian veterinarian)
    {
        if(this.repository.existsById(veterinarian.getVetId()))
            return this.repository.save(veterinarian);
            return null;

    }

    @Override
    public boolean delete(Integer vetId) {
        this.repository.deleteById(vetId);
        if(this.repository.existsById(vetId)) {

            return false;
        }
        else
            return true;
    }

    @Override
    public Set<Veterinarian> getAll()
    {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
