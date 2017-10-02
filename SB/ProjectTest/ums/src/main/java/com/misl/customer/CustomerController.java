package com.misl.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mojidul on 27-Sep-17.
 */
@RestController
public class CustomerController {
    @Autowired
    private ICustomerService _customerService;

    @RequestMapping(method= RequestMethod.POST,value="/customer")
    public void InsertCustomer(@RequestBody Customer customer){
        _customerService.CreateCustomer(customer);
    }
    @RequestMapping(method=RequestMethod.PUT,value="/customer/{id}")
    public void EditCustomer(@RequestBody Customer customer,@PathVariable long id){
        _customerService.editCustomer(customer,id);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/customer/{id}")
    public void deleteCustomer(@PathVariable long id){
        _customerService.deleteCustomer(id);
    }
    @RequestMapping(value="/customer/{id}")
    public Customer getCustomerById(@PathVariable long id){
        return _customerService.getCustomerById(id);
    }

}
