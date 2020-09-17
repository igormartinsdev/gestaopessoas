package com.im.gestaopessoa.service.exceptions;

public class PessoaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PessoaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public PessoaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
