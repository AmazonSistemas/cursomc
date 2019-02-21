package com.alessandro.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		//Todos os valores possiveis no ENUM (Se o codigo informado for = ao da lista, retorna o TipoCliente		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		//Caso informar um codigo invalido
		throw new IllegalArgumentException("ID do Tipo Cliente invalido : "+cod);
	}
	
}
