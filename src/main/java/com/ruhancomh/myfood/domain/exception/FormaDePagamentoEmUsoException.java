package com.ruhancomh.myfood.domain.exception;

public class FormaDePagamentoEmUsoException extends EntidadeEmUsoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Forma de pagamento não pode ser removida pois está em uso.";
	
	public FormaDePagamentoEmUsoException() {
		super(DEFAULT_MESSAGE);
	}

	public FormaDePagamentoEmUsoException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

}
