package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Cantante;

import java.util.List;

public interface CantanteService {
    List<Cantante> findAll();
    
    Cantante findById(String theId);
    
    Cantante save(Cantante elCantante);
    
    void deleteById(String theId);
}
