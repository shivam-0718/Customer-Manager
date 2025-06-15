package com.customermanager.service;

import com.customermanager.model.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomerInfo();
    void registerCustomer(Customer customer);
    Customer fetchCustomerById(Integer id);
    void deleteCustomer(Integer id);

}
