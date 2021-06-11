package za.ac.cput.Factory;

import za.ac.cput.Entity.Staff;

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
