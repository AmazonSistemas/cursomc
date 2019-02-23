package com.alessandro.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.alessandro.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pagamento")
@Inheritance(strategy=InheritanceType.JOINED) //Fazer heranca para Pagamento(Boleto/Cartao), nesse caso uma tabela para cada tipo
// @Inheritance(strategy=InheritanceType.SINGLE_TABLE) //Fazer heranca para Pagamento(Boleto/Cartao), nesse caso um tabelao com todos os atributos
public abstract class Pagamento implements Serializable{
//Abstract é para garantir que nao vou instanciar objeto do tipo Pagamento e sim, pagamentoCom(Boleto/Cartao)
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="i_pagamento")
	private Integer id;
	//private EstadoPagamento estado; Nao posso colocar assim pois vou gravar no banco um INTEGER
	private Integer estado;

	@JsonIgnore //Os Pagamento do Pedido NÃO seram Serializados (Assossiação de Mão Dupla)
	@OneToOne  // Um para UM com PEDIDO
	@JoinColumn(name="i_pedido")  //Estou informando que o i_pedido é o mesmo do PEDIDO 
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {
		
	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}