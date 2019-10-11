package com.fatecararas.palestras;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatecararas.palestras.domain.Categoria;
import com.fatecararas.palestras.domain.Cliente;
import com.fatecararas.palestras.domain.Palestra;
import com.fatecararas.palestras.domain.enums.TipoAluno;
import com.fatecararas.palestras.repositories.CategoriaRepository;
import com.fatecararas.palestras.repositories.ClienteRepository;
import com.fatecararas.palestras.repositories.PalestraRepository;

@SpringBootApplication
public class PalestrasApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private PalestraRepository palestrarepository;
	@Autowired
	private ClienteRepository clienterepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PalestrasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Segurança da Informação");
		Categoria cat2 = new Categoria(null, "Desenvolvimento WEB");
		
		
		Palestra p1 = new Palestra(null, "Spring", 10.0);
		Palestra p2 = new Palestra(null, "Rails", 20.0);
		Palestra p3 = new Palestra(null, "Pentest", 30.0);
		
		p1.getCategorias().addAll(Arrays.asList(cat2));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		cat1.getPalestras().addAll(Arrays.asList(p3));
		cat2.getPalestras().addAll(Arrays.asList(p1, p2));
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		palestrarepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Cliente cli1  = new Cliente(null, "Orlando", "orlandosaraivajr@gmail.com", "12345678910", TipoAluno.ALUNOEXTERNO);
		clienterepository.saveAll(Arrays.asList(cli1));
	}

}
