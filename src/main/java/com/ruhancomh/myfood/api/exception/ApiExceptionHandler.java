package com.ruhancomh.myfood.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.exception.NegocioException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> defaultHandle(Throwable e) {
		return this.formatResponse(HttpStatus.BAD_REQUEST, e);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleNegocioException(NegocioException e) {
		return this.formatResponse(HttpStatus.BAD_REQUEST, e);
	}

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<?> handleRecursoNaoEncontrado(RecursoNaoEncontradoException e) {
		return this.formatResponse(HttpStatus.NOT_FOUND, e);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<?> handleEntidadeEmUso(EntidadeEmUsoException e) {
		return this.formatResponse(HttpStatus.CONFLICT, e);
	}
	
	private ResponseEntity<?> formatResponse(HttpStatus status, Throwable e) {
		return ResponseEntity.status(status).body(this.getExceptionResponse(e));
	}
	
	private ExceptionResponse getExceptionResponse(Throwable e) {
		return ExceptionResponse.builder()
				.mensagem(e.getMessage())
				.dataHora(LocalDateTime.now())
				.build();
	}
}
