package com.ruhancomh.myfood.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.exception.EntidadeRelacionadaNaoEncontradaException;
import com.ruhancomh.myfood.domain.exception.NegocioException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleDefault(Exception ex, WebRequest request) {
		return this.handleCustomException(HttpStatus.BAD_REQUEST, ExceptionTypes.NAO_MAPEADA, ex, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request) {
		return this.handleCustomException(HttpStatus.BAD_REQUEST, ExceptionTypes.NEGOCIO, ex, request);
	}
	
	@ExceptionHandler(EntidadeRelacionadaNaoEncontradaException.class)
	public ResponseEntity<?> handleEntidadeRelacionadaNaoEncontrada(EntidadeRelacionadaNaoEncontradaException ex,
			WebRequest request) {
		return this.handleCustomException(HttpStatus.BAD_REQUEST,
				ExceptionTypes.ENTIDADE_RELACIONADA_NAO_ENCONTRADA, ex, request);
	}

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex, WebRequest request) {
		return this.handleCustomException(HttpStatus.NOT_FOUND, ExceptionTypes.ENTIDADE_EM_USO, ex, request);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<Object> handleEntidadeEmUso(EntidadeEmUsoException ex, WebRequest request) {
		return this.handleCustomException(HttpStatus.CONFLICT, ExceptionTypes.ENTIDADE_EM_USO, ex, request);
	}
	
	private ResponseEntity<Object> handleCustomException(HttpStatus status, ExceptionTypes exceptionType,
			Exception ex, WebRequest request) {
		return this.handleExceptionInternal(ex, this.getCustomExceptionResponse(status, exceptionType, ex), new HttpHeaders(), status, request);
	}

	private ExceptionResponse getCustomExceptionResponse(HttpStatus status, ExceptionTypes exceptionType,
			Exception ex) {
		return ExceptionResponse.builder()
				.status(status.value())
				.type(exceptionType.getType())
				.title(exceptionType.getTitle())
				.detail(ex.getMessage())
				.build();
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return super.handleExceptionInternal(ex, this.getDefaultExceptionResponse(ex, body, status),
				headers, status, request);
	}
	
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, ExceptionResponse body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	private ExceptionResponse getDefaultExceptionResponse(Exception ex, Object body, HttpStatus status) {	
		return ExceptionResponse.builder()
				.title(this.getDefaultExceptionTitle(body, status))
				.status(status.value())
				.build();
	}

	private String getDefaultExceptionTitle(Object body, HttpStatus status) {
		if (body == null) {
			return status.getReasonPhrase();
		}
		
		if (body instanceof String) {
			return (String) body;
		}
		
		return "Error";
	}
	
}
