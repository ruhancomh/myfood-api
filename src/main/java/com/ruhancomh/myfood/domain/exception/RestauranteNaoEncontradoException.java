package com.ruhancomh.myfood.domain.exception;

public class RestauranteNaoEncontradoException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhum restaurante encontrado para o id: %s";

	public RestauranteNaoEncontradoException(Long cidadeId, Throwable cause) {
		super(getDefaultMessage(cidadeId), cause);
	}
	
	public RestauranteNaoEncontradoException(Long cidadeId) {
		super(getDefaultMessage(cidadeId));
	}
	
	private static String getDefaultMessage(Long cidadeId) {
		return String.format(DEFAULT_MESSAGE, cidadeId);
	}
	
}
