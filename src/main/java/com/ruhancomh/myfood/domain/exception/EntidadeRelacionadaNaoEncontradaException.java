package com.ruhancomh.myfood.domain.exception;

public class EntidadeRelacionadaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM = "Entidade relacionada %s não encontrada para o id: %s";
	
	public EntidadeRelacionadaNaoEncontradaException (String entidadeNome, Long entidadeId) {
		super(String.format(MENSAGEM, entidadeNome, entidadeId));
	}
}
