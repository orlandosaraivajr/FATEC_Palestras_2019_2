package com.fatecararas.palestras;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatecararas.palestras.domain.Categoria;
import com.fatecararas.palestras.domain.Cliente;
import com.fatecararas.palestras.domain.Pagamento;
import com.fatecararas.palestras.domain.PagamentoComBoleto;
import com.fatecararas.palestras.domain.PagamentoComCartao;
import com.fatecararas.palestras.domain.Palestra;
import com.fatecararas.palestras.domain.Pedido;
import com.fatecararas.palestras.domain.enums.EstadoPagamento;
import com.fatecararas.palestras.domain.enums.TipoAluno;
import com.fatecararas.palestras.repositories.CategoriaRepository;
import com.fatecararas.palestras.repositories.ClienteRepository;
import com.fatecararas.palestras.repositories.PagamentoRepository;
import com.fatecararas.palestras.repositories.PalestraRepository;
import com.fatecararas.palestras.repositories.PedidoRepository;

@SpringBootApplication
public class PalestrasApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private PalestraRepository palestrarepository;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private PagamentoRepository pagamentorepository;
	@Autowired
	private PedidoRepository pedidorepository;
	
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
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, date.parse("04/09/2019 15:00"), cli1);
		Pedido ped2 = new Pedido(null, date.parse("04/09/2019 15:10"), cli1);
		
		Pagamento pagto1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped1, date.parse("15/09/2019 00:00"), date.parse("20/10/2019 00:00"));
		Pagamento pagto2 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped2, 3);
		
		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidorepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentorepository.saveAll(Arrays.asList(pagto1, pagto2));
	}

}
