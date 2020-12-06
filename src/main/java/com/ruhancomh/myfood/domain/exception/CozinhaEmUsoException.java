package com.ruhancomh.myfood.domain.exception;

public class CozinhaEmUsoException extends EntidadeEmUsoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Cozinha não pode ser removida pois está em uso.";
	
	public CozinhaEmUsoException() {
		super(DEFAULT_MESSAGE);
	}

	public CozinhaEmUsoException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

}
