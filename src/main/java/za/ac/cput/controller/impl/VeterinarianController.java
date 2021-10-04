package za.ac.cput.controller.impl;

/*
    VeterinarianController.java
    Author: Nonhlahla Hlungwani (218160658)
    Date: 28 August 2021
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.service.impl.VeterinarianService;
import java.util.Set;

@RestController
@RequestMapping("/veterinarian")
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Veterinarian create(@RequestBody Veterinarian veterinarian)
    {
        return veterinarianService.create(veterinarian);
    }

    @GetMapping("/read/{id}")
    public Veterinarian read(@PathVariable Integer id)
    {
        return veterinarianService.read(id);
    }

    @PostMapping("/update")
    public Veterinarian update(@RequestBody Veterinarian veterinarian)
    {
        return veterinarianService.update(veterinarian);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id)
    {
        if (veterinarianService.delete(id))
            return "Successfully deleted";
        else
            return "could not delete";
    }

    @GetMapping("/getall")
    public Set<Veterinarian> getAll()
    {
        return veterinarianService.getAll();
    }


}
