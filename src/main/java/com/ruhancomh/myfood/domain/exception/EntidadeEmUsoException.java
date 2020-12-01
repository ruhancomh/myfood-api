package com.ruhancomh.myfood.domain.exception;

public class EntidadeEmUsoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM = "Entidade não pode ser removida pois está em uso.";

	public EntidadeEmUsoException() {
		super(MENSAGEM);
	}
	
}
