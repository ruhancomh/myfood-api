package com.ruhancomh.myfood.api.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ruhancomh.myfood.domain.exception.EntidadeEmUsoException;
import com.ruhancomh.myfood.domain.exception.EntidadeRelacionadaNaoEncontradaException;
import com.ruhancomh.myfood.domain.exception.NegocioException;
import com.ruhancomh.myfood.domain.exception.RecursoNaoEncontradoException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

	    String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";
	    
	    BindingResult bindingResult = ex.getBindingResult();
	    
	    List<ExceptionResponse.Field> problemFields = bindingResult.getFieldErrors().stream()
	    		.map(fieldError -> {
	    			String message = this.messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
	    			
	    			return ExceptionResponse.Field.builder()
	    				.name(fieldError.getField())
	    				.userMessage(message)
	    				.build();
	    		})
	    		.collect(Collectors.toList());
	    
	    ExceptionResponse response = ExceptionResponse.builder()
				.status(status.value())
				.type(ExceptionTypes.NAO_MAPEADA.getType())
				.title(ExceptionTypes.NAO_MAPEADA.getTitle())
				.detail(detail)
				.fields(problemFields)
				.build();
	    
	    return handleExceptionInternal(ex, response, headers, status, request);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleDefault(Exception ex, WebRequest request) {
		return this.handleCustomException(HttpStatus.BAD_REQUEST, ExceptionTypes.NAO_MAPEADA, ex, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, 
	        HttpHeaders headers, HttpStatus status, WebRequest request) {
		return this.handleCustomException(status, ExceptionTypes.URI_NAO_ENCONTRADO, ex, request);
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
		return this.handleCustomException(HttpStatus.NOT_FOUND, ExceptionTypes.RECURSO_NAO_ENCONTRADO, ex, request);
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
