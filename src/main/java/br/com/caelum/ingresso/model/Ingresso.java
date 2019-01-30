package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.caelum.ingresso.model.descontos.Desconto;

public class Ingresso {

	//Atributos
	private Sessao sessao;
	private BigDecimal preco;
	
/**
 * @deprecated hibernate only
 */
	public Ingresso() {}
	//construtor
	public Ingresso (Sessao sessao, Desconto tipoDeDesconto) {
	    this.sessao = sessao;
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());

	}
	
	public BigDecimal getPreco() {
	return preco.setScale(2,RoundingMode.HALF_UP);
		}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	}

