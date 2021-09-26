package za.ac.cput.service.impl;
/*
    IVeterinarianService.java
    Author: Nonhlahla Hlungwani (218160658)
    Date: 02 August 2021
 */
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IVeterinarianService extends IService<Veterinarian, Integer> {

    Set<Veterinarian> getAll();

    Veterinarian read(Integer vetId);

    boolean delete(Integer vetId);
}