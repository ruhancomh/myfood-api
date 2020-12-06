package com.ruhancomh.myfood.domain.exception;

public class RestauranteEmUsoException extends EntidadeEmUsoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Restaurante não pode ser removido pois está em uso.";
	
	public RestauranteEmUsoException() {
		super(DEFAULT_MESSAGE);
	}

	public RestauranteEmUsoException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

}
