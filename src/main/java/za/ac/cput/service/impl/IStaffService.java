package za.ac.cput.service.impl;

/**
 * IStaffService.java
 * Service interface for the Staff entity
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 **/

import za.ac.cput.entity.Staff;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IStaffService extends IService<Staff, Integer> {

    Set<Staff> getAll();
    Integer getSize();
}
