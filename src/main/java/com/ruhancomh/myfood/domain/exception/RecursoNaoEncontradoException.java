package com.ruhancomh.myfood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String MENSAGEM = "Nenhum recurso do tipo %s encontrado para o id: %s";
	
	public RecursoNaoEncontradoException (String recurso, Long recursoId) {
		super(String.format(MENSAGEM, recurso, recursoId));
	}

}
