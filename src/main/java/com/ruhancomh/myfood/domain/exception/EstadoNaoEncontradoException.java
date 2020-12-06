package com.ruhancomh.myfood.domain.exception;

public class EstadoNaoEncontradoException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhum estado encontrado para o id: %s";

	public EstadoNaoEncontradoException(Long estadoId, Throwable cause) {
		super(getDefaultMessage(estadoId), cause);
	}
	
	public EstadoNaoEncontradoException(Long estadoId) {
		super(getDefaultMessage(estadoId));
	}
	
	private static String getDefaultMessage(Long estadoId) {
		return String.format(DEFAULT_MESSAGE, estadoId);
	}
	
}
