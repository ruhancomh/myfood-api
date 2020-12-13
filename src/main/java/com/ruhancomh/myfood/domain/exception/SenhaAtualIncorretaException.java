package com.ruhancomh.myfood.domain.exception;

public class SenhaAtualIncorretaException extends NegocioException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "A senha atual fornecida está incorreta" ;

	public SenhaAtualIncorretaException() {
		super(DEFAULT_MESSAGE);
	}


}
