package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.FutbolistaRepository;
import com.luv2code.springboot.cruddemo.entity.Futbolista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Futbolista findById(int theId) {
        Optional<Futbolista> result = futbolistaRepository.findById(theId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("No se encontró el futbolista con id - " + theId);
        }
    }

    @Override
    public Futbolista save(Futbolista elFutbolista) {
        return futbolistaRepository.save(elFutbolista);
    }

    @Override
    public void deleteById(int theId) {
        futbolistaRepository.deleteById(theId);
    }
}