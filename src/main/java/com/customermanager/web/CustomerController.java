package com.customermanager.web;

import com.customermanager.model.Customer;
import com.customermanager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class CustomerController {
    private ICustomerService service;

    @Autowired
    public CustomerController(ICustomerService service) {
        this.service = service;
    }

    @GetMapping("/customer-info")
    public String getCxData(Model model) {
        System.out.println("Fetching customer data..."); //for debugging purposes
        List<Customer> customers = service.getCustomerInfo();
        model.addAttribute("customers", customers);
        customers.forEach(c -> System.out.println(c)); //For debugging purposes
        return "customerinfo";
    }

}
