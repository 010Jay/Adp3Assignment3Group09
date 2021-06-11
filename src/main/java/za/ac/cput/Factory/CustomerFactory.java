/*CustomerFactory.java
Factory for the CustomerFactory
Author:Andy William Hine (219259038)
Date:07 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Customer;

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

}
