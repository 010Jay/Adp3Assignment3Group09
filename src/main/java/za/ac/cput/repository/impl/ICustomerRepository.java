/*ICustomerRepository.java
Repository for the ICustomerRepository
Author:Andy William Hine (219259038)
Date:23 July 2021
 */

package za.ac.cput.repository.impl;

import za.ac.cput.entity.Customer;
import za.ac.cput.repository.IRepository;


import java.util.Set;

@Deprecated
public interface ICustomerRepository extends IRepository<Customer,Integer>
{
  public Set<Customer>getAll();
}
