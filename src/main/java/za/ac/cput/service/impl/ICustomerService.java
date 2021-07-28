/*ICustomerService.java
Service for the ICustomerService
Author:Andy William Hine (219259038)
Date:27 July 2021
 */

package za.ac.cput.service.impl;

import za.ac.cput.entity.Customer;
import za.ac.cput.entity.Dog;
import za.ac.cput.service.IService;

import java.util.Set;

public interface ICustomerService extends IService<Customer,Integer>
{
    Set<Customer> getAll();
}
