package za.ac.cput.repository.impl;


import za.ac.cput.entity.Customer;
import za.ac.cput.entity.CustomerDescription;

import java.util.HashSet;
import java.util.Set;

public class CustomerDescriptionRepository implements ICustomerDescriptionRepository
{
    private static CustomerDescriptionRepository repository = null;
    private Set<CustomerDescription> customerDB;


    public CustomerDescriptionRepository()
    {
        this.customerDB = new HashSet<>();
    }

    public static CustomerDescriptionRepository getRepository()
    {
        if(repository == null)
        {
            repository = new CustomerDescriptionRepository();
        }

        return repository;
    }


    public CustomerDescription create(CustomerDescription customerDescription) {

        this.customerDB.add(customerDescription);
        return customerDescription;
    }


    public CustomerDescription read(Integer customerID) {

        CustomerDescription customerDescription = null;
        for (CustomerDescription cD : customerDB) {
            if (customerID.equals( cD.getId()))

            {
                customerDescription = cD;
                break;
            }
        }
        return customerDescription;
    }


    public CustomerDescription update(CustomerDescription customerDescription) {

        CustomerDescription oldCustomer = read(customerDescription.getId());

        if(oldCustomer != null)
        {
            customerDB.remove(oldCustomer);
            customerDB.add(customerDescription);

            return customerDescription;
        }
        return customerDescription;
    }

    public boolean delete(Integer integer) {

        CustomerDescription customerDescription = read(integer);

        if(customerDescription != null)
        {
            customerDB.remove(customerDescription);
            return true;
        }
        return false;
    }

    public Set<CustomerDescription> getAll(){return customerDB;} {

}

}
