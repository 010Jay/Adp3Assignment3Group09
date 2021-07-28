/*CustomerService.java
Service for the CustomerService
Author:Andy William Hine (219259038)
Date:27 July 2021
 */

package za.ac.cput.service.impl;

import za.ac.cput.entity.Customer;
import za.ac.cput.repository.impl.CustomerRepository;

import java.util.Set;

public class CustomerService implements ICustomerService
{
    private static CustomerService service= null;
    private CustomerRepository repository;

    //Constractor
    public CustomerService(CustomerRepository repository)
    {
        this.repository = repository;
    }

    public CustomerService() {

    }

    //Getter
    public static CustomerService getService()
    {
        if (service == null)
            service = new CustomerService();
        return service;
    }

    public Customer create(Customer customer)
    {
        return this.repository.create(customer);
    }

    public Customer read(Integer c)
    {
        return this.repository.read(c);
    }

    public Customer update(Customer customer)
    {
        return this.repository.update(customer);
    }

    public boolean delete(Integer c)
    {
       return this.repository.delete(c);
    }


    @Override
    public Set<Customer> getAll() {
        return null;
    }
}
