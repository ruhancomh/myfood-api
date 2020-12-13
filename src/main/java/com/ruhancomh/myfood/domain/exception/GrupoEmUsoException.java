package com.ruhancomh.myfood.domain.exception;

public class GrupoEmUsoException extends EntidadeEmUsoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Grupo não pode ser removido pois está em uso.";
	
	public GrupoEmUsoException() {
		super(DEFAULT_MESSAGE);
	}

	public GrupoEmUsoException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

}
