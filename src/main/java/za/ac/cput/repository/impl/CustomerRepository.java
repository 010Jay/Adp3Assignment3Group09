/*CustomerRepository.java
Repository for the CustomerRepository
Author:Andy William Hine (219259038)
Date:23 July 2021
 */

package za.ac.cput.repository.impl;

import za.ac.cput.entity.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository implements ICustomerRepository
{
    private static CustomerRepository Repository = null;
    private Set<Customer> customerDB;

    public CustomerRepository()
    {
        this.customerDB = new HashSet<>();
    }

    public static CustomerRepository getRepository() {
        if (Repository == null) {
            Repository = new CustomerRepository();
        }
        return Repository;
    }


    public Customer create(Customer customer) {

        boolean success = customerDB.add(customer);
        if (!success)
            return null;
        return customer;

    }

    public Customer read(Integer customerID) {
        Customer customer = null;
        for (Customer c : customerDB) {
            if (customerID.equals(c.getCustomerID()))
            {
                customer = c;
                break;
            }
        }
        return customer;
    }

       public Customer update(Customer customer)
       {

        Customer oldCustomer = read(customer.getCustomerID());

        if(oldCustomer!=null)
        {
            customerDB.remove(oldCustomer);
            customerDB.add(customer);
        }
        return customer;
        }


       public boolean delete(Integer customerID)
       {
        Customer customerToDelete = read(customerID);

        if(customerToDelete == null)
           return false;
        customerDB.remove(customerToDelete);
           return true;
        }

         public Set<Customer> getAll()
         {
            return customerDB;
         }

}
