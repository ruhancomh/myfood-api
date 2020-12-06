package com.ruhancomh.myfood.domain.exception;

public class CidadeNaoEncontradaException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhuma cidade encontrada para o id: %s";

	public CidadeNaoEncontradaException(Long cidadeId, Throwable cause) {
		super(getDefaultMessage(cidadeId), cause);
	}
	
	public CidadeNaoEncontradaException(Long cidadeId) {
		super(getDefaultMessage(cidadeId));
	}
	
	private static String getDefaultMessage(Long cidadeId) {
		return String.format(DEFAULT_MESSAGE, cidadeId);
	}
	
}
