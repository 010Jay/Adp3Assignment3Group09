/*CustomerService.java
Service for the CustomerService
Author:Andy William Hine (219259038)
Date:27 July 2021
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService
{
    private static CustomerService service= null;

    @Autowired
    private CustomerRepository repository;

    public static CustomerService getService()
    {
        if (service == null)
        {
            service = new CustomerService();
        }
        return service;
    }

    @Override
    public Customer create(Customer customer)
    {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(Integer customerID)
    {
        return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public Customer update(Customer customer)
    {
        if(this.repository.existsById(customer.getCustomerID()))
            return this.repository.save(customer);
            return null;
    }

    @Override
    public boolean delete(Integer customerID)
    {
        this.repository.deleteById(customerID);
       if(this.repository.existsById(customerID))
        return false;
        else
            return true;
    }

    @Override
    public Set<Customer> getAll(){return this.repository.findAll().stream().collect(Collectors.toSet());}


}
//    private static CustomerService service= null;
//    private CustomerRepository repository = null;
//
//    //Constractor
//    CustomerService()
//    {
//        this.repository = new CustomerRepository().getRepository();
//    }
//
//    //Getter
//    public static CustomerService getService()
//    {
//        if (service == null)
//        {
//            service = new CustomerService();
//        }
//
//        return service;
//    }
//
//    @Override
//    public Customer create(Customer customer)
//    {
//        return this.repository.create(customer);
//    }
//
//    @Override
//    public Customer read(Integer c)
//    {
//        return this.repository.read(c);
//    }
//
//    @Override
//    public Customer update(Customer customer)
//    {
//        return this.repository.update(customer);
//    }
//
//    @Override
//    public boolean delete(Integer c)
//    {
//       return this.repository.delete(c);
//    }
//
//
//    @Override
//    public Set<Customer> getAll() {
//        return this.repository.getAll();
//    }
//
////    public Set<Customer> getAllCustomersStartWith()
////    {
////        Set<Customer> customerWithJ = new HashSet<Customer>();
////        Set<Customer> customers = getAll();
////        for(Customer customer: customers)
////        {
////            if(customer.getDescription().trim().toLowerCase().startsWith("j"))
////            {
////                customerWithJ.add(customer);
////            }
////        }
////        return customerWithJ;
////    }

