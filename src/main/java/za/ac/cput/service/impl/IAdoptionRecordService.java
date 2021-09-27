package za.ac.cput.service.impl;

/*
    IAdoptionRecordService.java
    Service interface for the Adoption Record entity
    Author: Siyanda Hlongwa (217091229)
    Date: 24 September 2021
 */

import za.ac.cput.entity.AdoptionRecord;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IAdoptionRecordService extends IService<AdoptionRecord, Integer>
{
    Set<AdoptionRecord> getAll();

}
