package com.codz.controller;

import com.codz.dao.CustomerDAO;
import com.codz.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel){
        //get customers from dao
        List<Customer> theCustomers = customerDAO.getCustomers();

        //add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        System.out.println("customers: " + theCustomers);

        return "list-customers";
    }

}
