package za.ac.cput.service.impl;

/*
    AdoptionRecordServiceTest.java
    Test class for the Service implementation for the Adoption Record entity
    Author: Siyanda Hlongwa (217091229)
    Date: 24 September 2021
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.AdoptionRecord;
import za.ac.cput.factory.AdoptionRecordFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class AdoptionRecordServiceTest {//start of class

    //Atttributes
    @Autowired
    private static final Date date = new Date();
    private AdoptionRecordService service = AdoptionRecordService.getService();
    private static AdoptionRecord record1 = new AdoptionRecordFactory().createAdoptionRecord(001, 1001, 123456, 987654, date);
    private static AdoptionRecord record2 = new AdoptionRecord.Builder().copy(record1).setAdoptionId(90059).setDogId(1009).setCustomerId(744125).setStaffId(45612).setDate(date).build();


    @Test
    void a_create()
    {
        AdoptionRecord createRecord = service.create(record1);
        System.out.println("Created: " + createRecord.toString());
        assertEquals(createRecord.getAdoptionId(), record1.getAdoptionId());
    }

    @Test
    void b_read()
    {
        AdoptionRecord readRecord = service.read(record1.getAdoptionId());
        System.out.println("Reading: " + readRecord);
        assertNull(readRecord);
    }

    @Test
    void c_update()
    {
        AdoptionRecord updateRecord = service.update(record2);
        assertEquals(4, service.getAll());
        System.out.println("Record Update: " + updateRecord);
    }

    @Disabled
    @Test
    void e_delete()
    {
        boolean delete = service.delete(record1.getAdoptionId());
       assertTrue(delete);
        System.out.println("Delete: " + true);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show all:");
        System.out.println("---------");
        System.out.println(service.getAll());
        System.out.println("---------");
    }

}//end of class