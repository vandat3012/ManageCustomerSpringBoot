package com.example.springbootmanagecustomer.service;

import com.example.springbootmanagecustomer.model.Customer;
import com.example.springbootmanagecustomer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        iCustomerRepository.save(customer);
        return customer;
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }
}
