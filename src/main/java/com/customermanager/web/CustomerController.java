package com.customermanager.web;

import com.customermanager.model.Customer;
import com.customermanager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/register-customer")
    public String registerCx(@ModelAttribute("customer") Customer customer, Model model) {
        System.out.println("Registering customer: " + customer); //for debugging purposes
        service.registerCustomer(customer);
        return "redirect:/customer-info";
    }

    @GetMapping("/show-form")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer()); // Create a new Customer object to bind form data
        return "showform";
    }

    @GetMapping("/update-form")
    public String updateCxInfo(@RequestParam("cxid") Integer id, Model model) {
        Customer cx = service.fetchCustomerById(id);
        model.addAttribute("customer", cx);
        return "updateform";
    }

    @GetMapping("/delete-data")
    public String deleteCxInfo(@RequestParam("cxid") Integer id) {
        service.deleteCustomer(id);
        return "redirect:/customer-info";
    }

}
