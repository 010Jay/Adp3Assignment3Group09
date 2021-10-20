package za.ac.cput.controller.impl;

/**
 * AdoptionRecordController.java
 * Controller for the AdoptionRecord service
 * Author: Siyanda Hlongwa (217091229)
 * Date: 12 August 2021
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.AdoptionRecord;
import za.ac.cput.service.impl.AdoptionRecordService;
import java.util.Set;


@RestController
@RequestMapping("/adoptionRecord")
public class AdoptionRecordController
{//start of class

    //Attributes
    @Autowired //Initialize the adoptionRecordService to be use by spring boot
    private AdoptionRecordService adoptionRecordService;

    //Create adoptionRecord
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public AdoptionRecord create(@RequestBody AdoptionRecord adoptionRecord)
    {
        return adoptionRecordService.create(adoptionRecord);
    }

    //Read
    @GetMapping("/read/{id}")
    public AdoptionRecord read(@PathVariable Integer id)
    {
        return adoptionRecordService.read(id);
    }

    //Update
    @PostMapping("/update")
    public AdoptionRecord update(@RequestBody AdoptionRecord adoptionRecord)
    {
        return adoptionRecordService.update(adoptionRecord);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id)
    {
        return adoptionRecordService.delete(id);
    }

    //getAll
    @GetMapping("/getAll")
    public Set<AdoptionRecord> getAll()
    {
        return adoptionRecordService.getAll();
    }
}//end of class
