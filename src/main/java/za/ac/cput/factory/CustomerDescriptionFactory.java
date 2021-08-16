package za.ac.cput.factory;

import za.ac.cput.entity.CustomerDescription;

public class CustomerDescriptionFactory
{
    public static CustomerDescription createCustomerDescription(int id) {
        return new CustomerDescription.Builder()
                .setId(id)
                .build();

    }
}
