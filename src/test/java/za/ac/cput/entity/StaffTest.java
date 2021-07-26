package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffTest {

    //Attributes
    Staff.Builder staff1;

    @BeforeEach
    void setUp() {

        staff1 = new Staff.Builder().setStaffId(10478).setName("Nomgcobo").setSurname("Hlwempu");
    }

    @Test
    public void testStaff()
    {
        System.out.println("staff1: " + staff1.toString());
    }
}
