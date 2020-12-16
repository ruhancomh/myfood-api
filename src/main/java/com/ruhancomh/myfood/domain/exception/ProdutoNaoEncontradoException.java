package com.ruhancomh.myfood.domain.exception;

public class ProdutoNaoEncontradoException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhum produto encontrado para o id: %s e restaurante: %s";

	public ProdutoNaoEncontradoException(Long produtoId, Long restauranteId, Throwable cause) {
		super(getDefaultMessage(produtoId, restauranteId), cause);
	}
	
	public ProdutoNaoEncontradoException(Long produtoId, Long restauranteId) {
		super(getDefaultMessage(produtoId, restauranteId));
	}
	
	private static String getDefaultMessage(Long produtoId, Long restauranteId) {
		return String.format(DEFAULT_MESSAGE, produtoId, restauranteId);
	}
	
}
