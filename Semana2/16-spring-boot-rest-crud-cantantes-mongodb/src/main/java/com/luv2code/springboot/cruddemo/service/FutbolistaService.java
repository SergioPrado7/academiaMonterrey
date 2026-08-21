package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Futbolista;

import java.util.List;

public interface FutbolistaService {
    List<Futbolista> findAll();
    
    Futbolista findById(String theId);
    
    Futbolista save(Futbolista elFutbolista);
    
    void deleteById(String theId);
}
