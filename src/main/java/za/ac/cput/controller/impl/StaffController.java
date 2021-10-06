package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Staff;
import za.ac.cput.service.impl.StaffService;

import java.util.Set;

/**
 * StaffController.java
 * Controller for the Staff service
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 **/

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService service;

    //Create dog
    @RequestMapping(value = "/create", method = RequestMethod.POST) //Specify path and http method.
    public Staff create(@RequestBody Staff staff) //@RequestBody to require parameters
    {
        return service.create(staff);
    }

    //Read
    @GetMapping("/read/{id}") //Another (shorter) way of specifying the path and method.
    public Staff read(@PathVariable Integer id)
    {
        return service.read(id);
    }

    //Update
    @PostMapping("/update")
    public Staff update(@RequestBody Staff staff)
    {
        return service.update(staff);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id)
    {
        return service.delete(id);
    }

    //getAll
    @GetMapping("/getAll")
    public Set<Staff> getAll()
    {
        return service.getAll();
    }
}
