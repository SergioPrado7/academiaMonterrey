package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Futbolista;
import com.luv2code.springboot.cruddemo.repository.FutbolistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantanteServiceImpl implements CantanteService {

    private FutbolistaRepository cantanteRepository;

    @Autowired
    public CantanteServiceImpl(FutbolistaRepository theCantanteRepository) {
        cantanteRepository = theCantanteRepository;
    }

    @Override
    public List<Futbolista> findAll() {
        return cantanteRepository.findAll();
    }

    @Override
    public Futbolista findById(String theId) {
        return cantanteRepository.findById(theId).orElse(null);
    }

    @Override
    public Futbolista save(Futbolista elCantante) {
        return cantanteRepository.save(elCantante);
    }

    @Override
    public void deleteById(String theId) {
        cantanteRepository.deleteById(theId);
    }
}
