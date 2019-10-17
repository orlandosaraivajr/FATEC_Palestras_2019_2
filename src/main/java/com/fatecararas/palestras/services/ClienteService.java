package com.fatecararas.palestras.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatecararas.palestras.domain.Cliente;
import com.fatecararas.palestras.repositories.ClienteRepository;
import com.fatecararas.palestras.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = this.repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
