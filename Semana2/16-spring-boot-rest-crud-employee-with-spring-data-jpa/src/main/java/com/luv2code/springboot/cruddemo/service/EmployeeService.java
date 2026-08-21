package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Futbolista;

import java.util.List;

public interface EmployeeService {

    List<Futbolista> findAll();

    Futbolista findById(int theId);

    Futbolista save(Futbolista theEmployee);

    void deleteById(int theId);

}
