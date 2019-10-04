package com.fatecararas.palestras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatecararas.palestras.domain.Palestra;

@Repository
public interface PalestraRepository extends JpaRepository<Palestra, Integer>{

}
