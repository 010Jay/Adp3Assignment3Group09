package za.ac.cput.controller.impl;

/**
 * DogController.java
 * Controller for the Dog service
 * Author: Jason Jaftha (217009301)
 * Date: 12 August 2021
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Dog;
import za.ac.cput.service.impl.DogService;
import java.util.Set;

//Dog Controller for the CRUD operations

@RestController
@RequestMapping("/dog")
public class DogController {

    //Attributes
        @Autowired //Initialize the dogService to be use by spring boot
        private DogService dogService;

    //Create dog
        @RequestMapping(value = "/create", method = RequestMethod.POST) //Specify path and http method.
        public Dog create(@RequestBody Dog dog) //@RequestBody to require parameters
        {
            return dogService.create(dog);
        }

    //Read
        @GetMapping("/read/{id}") //Another (shorter) way of specifying the path and method.
        public Dog read(@PathVariable Integer id)
        {
            return dogService.read(id);
        }

    //Update
        @PostMapping("/update")
        public Dog update(@RequestBody Dog dog)
        {
            return dogService.update(dog);
        }

    //Delete
        @DeleteMapping("/delete/{id}")
        public Boolean delete(@PathVariable Integer id)
        {
            return dogService.delete(id);
        }

    //getAll
        @GetMapping("/getAll")
        public Set<Dog> getAll()
        {
            return dogService.getAll();
        }
}
