package com.fatecararas.palestras.domain;

import javax.persistence.Entity;

import com.fatecararas.palestras.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	private Integer numerodeparcelas;
	
	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numerodeparcelas) {
		super(id, estado, pedido);
		this.numerodeparcelas = numerodeparcelas;
	}

	public Integer getNumerodeparcelas() {
		return numerodeparcelas;
	}

	public void setNumerodeparcelas(Integer numerodeparcelas) {
		this.numerodeparcelas = numerodeparcelas;
	}

	
	
}
