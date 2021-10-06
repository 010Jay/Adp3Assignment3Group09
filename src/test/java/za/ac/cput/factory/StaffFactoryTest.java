package za.ac.cput.factory;

/**
 * StaffFactoryTest.java
 * Test class for the Staff factory
 * Author: Nomgcobo Hlwempu (205205208)
 * Date: ??
 **/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Staff;

public class StaffFactoryTest {

    //Attributes
    Staff staff;

    @Test
    public void createStaff()
    {
        Staff staff = StaffFactory.createStaff (10478,"Nomgcobo","Hlwempu");
        System.out.println(staff);
    }

}
