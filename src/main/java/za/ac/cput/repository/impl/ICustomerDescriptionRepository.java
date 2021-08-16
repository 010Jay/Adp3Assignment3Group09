package za.ac.cput.repository.impl;

import za.ac.cput.entity.CustomerDescription;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ICustomerDescriptionRepository extends IRepository<CustomerDescription,Integer>
{
    Set<CustomerDescription> getAll();
}
