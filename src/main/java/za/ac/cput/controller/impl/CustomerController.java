/*CustomerHomeController.java
Home Controller for the Customer
Author:Andy William Hine (219259038)
Date:02 August 2021
 */

package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Customer;
import za.ac.cput.entity.Dog;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.impl.CustomerService;

import java.util.Set;


@RestController
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    //@PostMapping("/create") //easier way of doing this above

    public Customer create(@RequestBody Customer customer) {

        return customerService.create(customer);
    }


    @GetMapping("/read/{id}")
    public Customer read(@RequestBody Customer customer)
    {
        return customerService.read(customer.getCustomerID());
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer)
    {
        return customerService.update(customer);
    }

    @DeleteMapping ("/delete")
    public String delete(@RequestBody Customer customer) {
        if (customerService.delete(customer.getCustomerID()))
        {
            return "Successfully deleted!";
        }
        return "Could not delete a customer";
    }

    @GetMapping("/getAll")
    public Set<Customer> getAll()
    {
        return customerService.getAll();
    }

    @GetMapping("/getallwithj")
    public Set<Customer> getallwithj()
    {
        return customerService.getAllCustomersStartWith();
    }
}

