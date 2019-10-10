package com.fatecararas.palestras.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatecararas.palestras.domain.Categoria;
import com.fatecararas.palestras.repositories.CategoriaRepository;
import com.fatecararas.palestras.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = this.repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
		// Optional<Categoria> obj = this.repo.findById(id);
		// return obj.orElse(null);
	}
}
