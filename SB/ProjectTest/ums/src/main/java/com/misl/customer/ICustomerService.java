package com.misl.customer;

/**
 * Created by Mojidul on 27-Sep-17.
 */
public interface ICustomerService {
    public String CreateCustomer(Customer customer);
    public String editCustomer(Customer customer,long id);
    public String deleteCustomer(long id);
}
