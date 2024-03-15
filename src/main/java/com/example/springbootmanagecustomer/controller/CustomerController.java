package com.example.springbootmanagecustomer.controller;

import com.example.springbootmanagecustomer.model.Customer;
import com.example.springbootmanagecustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customers",iCustomerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate (@ModelAttribute ("customer")Customer customer) {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customers",new Customer());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Model model, Customer customer){
        model.addAttribute("customers",iCustomerService.save(customer));
        return "redirect:/customers";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit (@PathVariable Long id){
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customers",customerOptional.get());
        return modelAndView;
    }
    @PostMapping("/edit")
    public String edit (Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        iCustomerService.remove(id);
        return "redirect:/customers";
    }
}
