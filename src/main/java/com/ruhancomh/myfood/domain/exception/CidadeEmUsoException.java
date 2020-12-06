package com.ruhancomh.myfood.domain.exception;

public class CidadeEmUsoException extends EntidadeEmUsoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Cidade não pode ser removida pois está em uso.";
	
	public CidadeEmUsoException() {
		super(DEFAULT_MESSAGE);
	}

	public CidadeEmUsoException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

}
