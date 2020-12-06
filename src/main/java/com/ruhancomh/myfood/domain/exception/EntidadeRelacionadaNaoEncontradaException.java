package com.ruhancomh.myfood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EntidadeRelacionadaNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM = "Entidade relacionada %s não encontrada para o id: %s";
	
	public EntidadeRelacionadaNaoEncontradaException (String entidadeNome, Long entidadeId) {
		super(String.format(MENSAGEM, entidadeNome, entidadeId));
	}
}
