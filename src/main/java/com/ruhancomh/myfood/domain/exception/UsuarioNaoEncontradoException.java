package com.ruhancomh.myfood.domain.exception;

public class UsuarioNaoEncontradoException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhum usuário encontrado para o id: %s";

	public UsuarioNaoEncontradoException(Long usuarioId, Throwable cause) {
		super(getDefaultMessage(usuarioId), cause);
	}
	
	public UsuarioNaoEncontradoException(Long usuarioId) {
		super(getDefaultMessage(usuarioId));
	}
	
	private static String getDefaultMessage(Long usuarioId) {
		return String.format(DEFAULT_MESSAGE, usuarioId);
	}
	
}
