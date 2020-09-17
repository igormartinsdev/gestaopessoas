package com.im.gestaopessoa.domain.enderecoTipos;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Tipo {
	
	RUA("rua"),
	AVENIDA("avenida"),
	ESTRADA("estrada");
	
	Tipo(String descricao){
		this.descricao = descricao;
	}
	
	private String descricao;

	@JsonValue
	public String getDescricao() {
		return descricao;
	}

}
