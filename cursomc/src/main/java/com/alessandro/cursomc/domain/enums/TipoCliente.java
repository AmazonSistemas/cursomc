package com.alessandro.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1,"Pessoa Fisica"),
	PESSOJURIDICA(2, "Pessoa Juridica");
	
	private int cod;
	private String descricao;
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		//Todos os valores possiveis no ENUM (Se o codigo informado for = ao da lista, retorna o TipoCliente		
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		//Caso informar um codigo invalido
		throw new IllegalArgumentException("ID do Tipo Cliente invalido : "+cod);
	}

	
	
}
