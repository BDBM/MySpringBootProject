package com.misl.customer;

/**
 * Created by Mojidul on 02-Oct-17.
 */
public interface ICustomerRepository {
    public String createCustomer(Customer customer);
    public String editCustomer(Customer customer);
    public String deleteCustomer(long id);
}
