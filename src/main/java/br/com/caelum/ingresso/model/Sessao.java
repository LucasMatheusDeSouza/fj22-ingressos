package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	//atributos
	@Id
	@GeneratedValue
	private Integer id;
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	private BigDecimal preco;

	/**
	 * 
	 * @deprecated hibernate only
	 */
	
	public Sessao(){}
	// construtor de classe
	public Sessao(LocalTime horario, Filme filme, Sala sala) {
		this.horario = horario;
		this.filme = filme;
		this.sala = sala;
		this.preco = filme.getPreco().add(sala.getPreco());
	}
	
	
	//getters e setters
	public BigDecimal getPreco() {
		if(preco != null ) {
			return preco.setScale(2, RoundingMode.HALF_UP);

		}else {
			return BigDecimal.ZERO;
		}
		
		
		
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public LocalTime getHorarioTermino() {
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
	public LocalTime getHorario() {
		return horario;
	}
	public Sala getSala() {
		return sala;
	}
	public Filme getFilme() {
		return filme;
	}
	
	public Integer getId() {
		return id;
	}
}
