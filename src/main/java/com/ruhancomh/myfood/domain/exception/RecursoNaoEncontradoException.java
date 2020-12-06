package com.ruhancomh.myfood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public abstract class RecursoNaoEncontradoException extends NegocioException {

	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontradoException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public RecursoNaoEncontradoException(String message) {
		super(message);
	}

}
