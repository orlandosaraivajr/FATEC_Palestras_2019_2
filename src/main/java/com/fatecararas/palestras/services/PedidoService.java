package com.fatecararas.palestras.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatecararas.palestras.domain.Pedido;
import com.fatecararas.palestras.repositories.PedidoRepository;
import com.fatecararas.palestras.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = this.repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Pedido.class.getName()));
}
}
