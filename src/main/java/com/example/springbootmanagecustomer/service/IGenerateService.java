package com.example.springbootmanagecustomer.service;

import com.example.springbootmanagecustomer.model.Customer;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove (Long id);
}
