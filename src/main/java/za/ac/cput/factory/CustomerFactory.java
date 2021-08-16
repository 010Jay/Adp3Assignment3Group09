/*CustomerFactory.java
Factory for the CustomerFactory
Author:Andy William Hine (219259038)
Date:07 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Customer;

public class CustomerFactory
{

    public static Customer createCustomer(int customerID, String name, String surname, String emailAddress,
                                          String homeAddress, long phoneNumber)
    {
        //Creating a customer object, it did not need a genericHelper at all

        Customer customer = new Customer.Builder()
                .setCustomerID(customerID)
                .setName(name)
                .setSurname(surname)
                .setEmailAddress(emailAddress)
                .setHomeAddress(homeAddress)
                .setPhoneNumber(phoneNumber)
                .build();
        return customer;
    }

    public static Customer createCustomer(String description) {
        return createCustomer(33576543,"ants","butcha","Ants@gmail.com",
                            "3 Vato street",32454565);
    }
}
