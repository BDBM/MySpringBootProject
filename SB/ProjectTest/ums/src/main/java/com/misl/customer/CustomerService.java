package com.misl.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mojidul on 27-Sep-17.
 */
@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository _customerRepository;
    public String CreateCustomer(Customer customer){
    return _customerRepository.createCustomer(customer);
    }

    @Override
    public String editCustomer(Customer customer,long id) {
        return _customerRepository.editCustomer(customer);
    }

}
