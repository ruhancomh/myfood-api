package com.ruhancomh.myfood.domain.exception;

public class FormaDePagamentoNaoEncontradaException extends RecursoNaoEncontradoException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Nenhuma forma de pagamento encontrada para o id: %s";

	public FormaDePagamentoNaoEncontradaException(Long cidadeId, Throwable cause) {
		super(getDefaultMessage(cidadeId), cause);
	}
	
	public FormaDePagamentoNaoEncontradaException(Long cidadeId) {
		super(getDefaultMessage(cidadeId));
	}
	
	private static String getDefaultMessage(Long cidadeId) {
		return String.format(DEFAULT_MESSAGE, cidadeId);
	}
	
}
