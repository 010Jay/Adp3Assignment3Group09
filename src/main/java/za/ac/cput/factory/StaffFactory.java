package za.ac.cput.factory;

/**
 * StaffFactory.java
 * Factory for the Staff entity
 * Author: Nomgcobo Hlwempu (205205208)
 * Date: ??
 **/

import za.ac.cput.entity.Staff;

public class StaffFactory {


    public static Staff createStaff(int staffId, String name, String surname)
    {
        //Creating a staff object)

        Staff staff = new Staff.Builder()
                .setStaffId(staffId)
                .setName(name)
                .setSurname(surname)
                .build();
        return staff;
    }

}
