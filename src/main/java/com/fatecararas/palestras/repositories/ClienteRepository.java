package com.fatecararas.palestras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatecararas.palestras.domain.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
