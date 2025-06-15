package com.customermanager.service;

import com.customermanager.model.Customer;
import com.customermanager.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    private ICustomerRepo repo;

    @Autowired
    public void setRepo(ICustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Customer> getCustomerInfo() {
        return repo.findAll();
    }

    @Override
    public void registerCustomer(Customer customer) {
        repo.save(customer);
    }

    //Used for updating particular field. This has been written to cater as per UI.
    @Override
    public Customer fetchCustomerById(Integer id) {
        Optional<Customer> optional = repo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    //If record is present, it will be deleted.
    @Override
    public void deleteCustomer(Integer id) {
        repo.deleteById(id);
    }
}
