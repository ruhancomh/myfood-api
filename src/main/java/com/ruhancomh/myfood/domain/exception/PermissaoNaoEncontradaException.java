package com.ruhancomh.myfood.domain.exception;

public class PermissaoNaoEncontradaException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhuma permissao encontrada para o id: %s";

	public PermissaoNaoEncontradaException(Long permissaoId, Throwable cause) {
		super(getDefaultMessage(permissaoId), cause);
	}
	
	public PermissaoNaoEncontradaException(Long permissaoId) {
		super(getDefaultMessage(permissaoId));
	}
	
	private static String getDefaultMessage(Long permissaoId) {
		return String.format(DEFAULT_MESSAGE, permissaoId);
	}
	
}
