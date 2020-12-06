package com.ruhancomh.myfood.domain.exception;

public class CozinhaNaoEncontradaException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhuma cozinha encontrada para o id: %s";

	public CozinhaNaoEncontradaException(Long cidadeId, Throwable cause) {
		super(getDefaultMessage(cidadeId), cause);
	}
	
	public CozinhaNaoEncontradaException(Long cidadeId) {
		super(getDefaultMessage(cidadeId));
	}
	
	private static String getDefaultMessage(Long cidadeId) {
		return String.format(DEFAULT_MESSAGE, cidadeId);
	}
	
}
