package za.ac.cput.service.impl;

/**
 * StaffServiceTest.java
 * Test class for the Service implementation for the Staff entity.
 * Author: Jason Jaftha (217009301)
 * Date: 6 October 2021
 **/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class StaffServiceTest {

    @Autowired
    private StaffService service = StaffService.getService();
    private Staff staff1 = StaffFactory.createStaff(15, "Babarer", "Tomson");
    private Staff staff2 = new Staff.Builder().copy(staff1).setName("Tara").build();

    @Test
    void a_create() {

        Staff createStaff = service.create(staff1);
        System.out.println("Created: " + createStaff.toString());
        System.out.println("Size: " + service.getSize());
        assertEquals(createStaff.getStaffId(), staff1.getStaffId());
    }

    @Test
    void b_read() {

        Staff readStaff = service.read(staff1.getStaffId());
        System.out.println("Read: " + readStaff);
        assertNotNull(readStaff);
    }

    @Test
    void c_update() {

        Staff updateStaff = service.update(staff2);
        assertEquals(1, service.getSize());
        System.out.println("Updated: " + updateStaff.toString());
    }

    @Disabled
    @Test
    void e_delete() {

        service.delete(staff1.getStaffId());
        System.out.println("Delete: <size = " + service.getSize() + " >");
        assertEquals(0,service.getSize());
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show all:");
        System.out.println("---------");
        System.out.println(service.getAll());
        System.out.println("---------");
    }

}