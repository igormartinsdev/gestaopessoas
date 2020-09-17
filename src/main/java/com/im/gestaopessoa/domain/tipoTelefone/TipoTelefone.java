package com.im.gestaopessoa.domain.tipoTelefone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoTelefone {
	
	CONTATO("contato"),
	RESIDENCIAL("residencial"),
	COMERCIAL("comercial");
	
	TipoTelefone(String descricao){
		this.descricao = descricao;
	}
	
	private String descricao;

	@JsonValue
	public String getDescricao() {
		return descricao;
	}

}
