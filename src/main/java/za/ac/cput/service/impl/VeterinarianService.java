package za.ac.cput.service.impl;
/*
    Veterinarian.java
    Veterinarian Entity with builder Pattern
    Author: Nonhlahla Hlungwani (218160658)
    Date: 02 August 2021
 */
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.repository.impl.VeterinarianRepository;

import java.util.Set;

public class VeterinarianService implements IVeterinarianService {
    private static VeterinarianService service=null;
    private VeterinarianRepository repository;

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
        return this.repository.create(veterinarian);
    }

    @Override
    public Veterinarian read(Integer integer) {
        return null;
    }

    @Override
    public Veterinarian read(String s)
    {
        return this.repository.read(s);
    }
    @Override
    public Veterinarian update(Veterinarian veterinarian)
    {
        return this.repository.update(veterinarian);
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean delete(String s)
    {
        return this.repository.delete(s);
    }
    @Override
    public Set<Veterinarian> getAll()
    {
        return this.repository.getAll();
    }
}
