package com.fatecararas.palestras;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatecararas.palestras.domain.Categoria;
import com.fatecararas.palestras.repositories.CategoriaRepository;

@SpringBootApplication
public class PalestrasApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriarepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PalestrasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Segurança da Informação");
		Categoria cat2 = new Categoria(null, "Desenvolvimento WEB");
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
