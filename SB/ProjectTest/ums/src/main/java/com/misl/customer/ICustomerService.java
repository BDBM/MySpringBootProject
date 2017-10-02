package com.misl.customer;

import java.util.List;

/**
 * Created by Mojidul on 27-Sep-17.
 */
public interface ICustomerService {
    public String CreateCustomer(Customer customer);
    public String editCustomer(Customer customer,long id);
    public String deleteCustomer(long id);
    public Customer getCustomerById(long id);
    public List<Customer> getAllCustomer();
}
