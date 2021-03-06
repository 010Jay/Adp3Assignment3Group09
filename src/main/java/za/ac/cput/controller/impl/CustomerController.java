/*CustomerHomeController.java
Home Controller for the Customer
Author:Andy William Hine (219259038)
Date:02 August 2021
 */

package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Customer;
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
    public Customer read(@PathVariable Integer id)
    {
        return customerService.read(id);
    }


    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer)
    {
        return customerService.update(customer);
    }


    @DeleteMapping ("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if (customerService.delete(id))
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

}

