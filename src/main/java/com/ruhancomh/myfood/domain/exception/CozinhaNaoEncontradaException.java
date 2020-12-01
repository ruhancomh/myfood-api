package com.ruhancomh.myfood.domain.exception;

public class CozinhaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM = "Nenhuma cozinha encontrada para o id: %s";
	
	public CozinhaNaoEncontradaException (Long cozinhaId) {
		super(String.format(MENSAGEM, cozinhaId));
	}

}
