package com.customermanager.web;

import com.customermanager.model.Customer;
import com.customermanager.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@Tag(name = "Customer Controller", description = "Handles customer data, registration, updates, and deletion.")
public class CustomerController {
    private ICustomerService service;

    @Autowired
    public CustomerController(ICustomerService service) {
        this.service = service;
    }

    @GetMapping("/customer-info")
    @Operation(summary = "GET Operation", description = "This method is used to retrieve the customer details and display them on the customer info page.")
    public String getCustomerData(Model model) {
        System.out.println("Fetching customer data..."); //for debugging purposes
        List<Customer> customers = service.getCustomerInfo();
        model.addAttribute("customers", customers);
        customers.forEach(c -> System.out.println(c)); //For debugging purposes
        return "customerinfo";
    }

    @PostMapping("/register-customer")
    @Operation(summary = "POST Operation", description = "This method is used to register the customer details and display the updated customer info list on the customer info page.")
    public String registerCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        System.out.println("Registering customer: " + customer); //for debugging purposes
        service.registerCustomer(customer);
        return "redirect:/customer-info";
    }

    @GetMapping("/show-form")
    @Operation(summary = "GET Operation", description = "This method displays the Customer registration form.")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer()); // Create a new Customer object to bind form data
        return "showform";
    }

    @GetMapping("/update-form")
    @Operation(summary = "GET Operation", description = "This method updates the existing Customer data with the help of UI.")
    public String updateCustomerInfo(@RequestParam("customerId") Integer id, Model model) {
        Customer cx = service.fetchCustomerById(id);
        model.addAttribute("customer", cx);
        return "showform";
    }

    @GetMapping("/delete-data")
    @Operation(summary = "GET Operation", description = "This method deletes the existing Customer data with the help of UI.")
    public String deleteCustomerInfo(@RequestParam("customerId") Integer id) {
        service.deleteCustomer(id);
        return "redirect:/customer-info";
    }

}
