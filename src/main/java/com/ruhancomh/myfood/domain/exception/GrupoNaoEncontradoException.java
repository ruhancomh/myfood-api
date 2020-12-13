package com.ruhancomh.myfood.domain.exception;

public class GrupoNaoEncontradoException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhum grupo encontrado para o id: %s";

	public GrupoNaoEncontradoException(Long grupoId, Throwable cause) {
		super(getDefaultMessage(grupoId), cause);
	}
	
	public GrupoNaoEncontradoException(Long grupoId) {
		super(getDefaultMessage(grupoId));
	}
	
	private static String getDefaultMessage(Long grupoId) {
		return String.format(DEFAULT_MESSAGE, grupoId);
	}
	
}
