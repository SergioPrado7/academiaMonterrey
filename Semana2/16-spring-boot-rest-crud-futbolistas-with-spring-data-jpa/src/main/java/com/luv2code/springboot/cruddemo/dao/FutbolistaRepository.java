package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FutbolistaRepository extends JpaRepository<Futbolista, Integer> {
	
}
