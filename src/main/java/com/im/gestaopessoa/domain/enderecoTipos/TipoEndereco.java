package com.im.gestaopessoa.domain.enderecoTipos;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoEndereco {
	
	COMERCIAL("comercial"),
	RESIDENCIAL("residencial");
	
	private String descricao;
	
	TipoEndereco(String descricao){
		this.descricao = descricao;
	}

	@JsonValue
	public String getDescricao() {
		return descricao;
	}

}
