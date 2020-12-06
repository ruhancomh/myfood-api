package com.ruhancomh.myfood.domain.exception;

public class EstadoEmUsoException extends EntidadeEmUsoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Estado não pode ser removida pois está em uso.";
	
	public EstadoEmUsoException() {
		super(DEFAULT_MESSAGE);
	}

	public EstadoEmUsoException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

}
