package za.ac.cput.service.impl;

/**
 * StaffService.java
 * Staff Service implementation for the Dog entity
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Staff;
import za.ac.cput.repository.StaffRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StaffService implements IStaffService{

    @Autowired
    private StaffRepository repository;
    private static StaffService service;

    public static StaffService getService()
    {
        if (service == null)
        {
            service = new StaffService();
        }

        return service;
    }

    @Override
    public Staff create(Staff staff) {
        return this.repository.save(staff);
    }

    @Override
    public Staff read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Staff update(Staff staff) {
        if(this.repository.existsById(staff.getStaffId()))
        {
            return this.repository.save(staff);
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        this.repository.deleteById(id);

        if(this.repository.existsById(id))
        {
            return false;
        }

        return true;
    }

    @Override
    public Set<Staff> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Integer getSize() {
        return this.repository.findAll().stream().collect(Collectors.toSet()).size();
    }
}
