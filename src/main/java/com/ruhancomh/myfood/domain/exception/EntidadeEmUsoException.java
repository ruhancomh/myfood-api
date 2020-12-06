package com.ruhancomh.myfood.domain.exception;

public abstract class EntidadeEmUsoException extends NegocioException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeEmUsoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadeEmUsoException(String message) {
		super(message);
	}
	
}
