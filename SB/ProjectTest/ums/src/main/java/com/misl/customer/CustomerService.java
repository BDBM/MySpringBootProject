package com.misl.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public String deleteCustomer(long id) {
        return _customerRepository.deleteCustomer(id);
    }

    @Override
    public Customer getCustomerById(long id) {
        return _customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return _customerRepository.getAllCustomer();
    }

}
