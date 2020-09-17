package com.im.gestaopessoa.domain.tipoDependente;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoDependente {
	
	FILHO("filho"),
	MAE("mae"),
	PAI("pai"),
	ESPOSA("esposa");
	
	TipoDependente(String descricao){
		this.descricao = descricao;
	}
	
	private String descricao;

	@JsonValue
	public String getDescricao() {
		return descricao;
	}

}
