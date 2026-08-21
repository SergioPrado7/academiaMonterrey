package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Cantante;
import com.luv2code.springboot.cruddemo.repository.CantanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Antes se inyectaba EmployeeDAO. Ahora es el repositorio de Spring Data,
    // que no tiene implementación escrita a mano.
    private CantanteRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(CantanteRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Cantante> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Cantante findById(String theId) {

        // findById() devuelve Optional<Employee>. Lo convertimos a null para
        // conservar el mismo contrato que tenía la versión con JPA: el
        // controlador sigue comprobando "if (tempEmployee == null)".
        return employeeRepository.findById(theId).orElse(null);
    }

    // Ojo: aquí ya no hay @Transactional.
    //
    // MongoDB en modo standalone (un contenedor suelto, sin replica set) no
    // soporta transacciones multi-documento. Y no hacen falta: cada operación
    // toca un solo documento, y MongoDB garantiza atomicidad por documento.
    @Override
    public Cantante save(Cantante theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(String theId) {
        employeeRepository.deleteById(theId);
    }
}
