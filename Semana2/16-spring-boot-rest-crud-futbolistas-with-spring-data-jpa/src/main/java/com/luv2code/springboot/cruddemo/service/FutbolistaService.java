package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Futbolista;

import java.util.List;

public interface FutbolistaService {
    List<Futbolista> findAll();
    
    Futbolista findById(int theId);
    
    Futbolista save(Futbolista elFutbolista);
    
    void deleteById(int theId);
}
