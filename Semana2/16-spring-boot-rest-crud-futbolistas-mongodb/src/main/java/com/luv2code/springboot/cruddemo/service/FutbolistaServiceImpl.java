package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Futbolista;
import com.luv2code.springboot.cruddemo.repository.FutbolistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FutbolistaServiceImpl implements FutbolistaService {

    private FutbolistaRepository futbolistaRepository;

    @Autowired
    public FutbolistaServiceImpl(FutbolistaRepository theFutbolistaRepository) {
        futbolistaRepository = theFutbolistaRepository;
    }

    @Override
    public List<Futbolista> findAll() {
        return futbolistaRepository.findAll();
    }

    @Override
    public Futbolista findById(String theId) {
        return futbolistaRepository.findById(theId).orElse(null);
    }

    @Override
    public Futbolista save(Futbolista elFutbolista) {
        return futbolistaRepository.save(elFutbolista);
    }

    @Override
    public void deleteById(String theId) {
        futbolistaRepository.deleteById(theId);
    }
}
