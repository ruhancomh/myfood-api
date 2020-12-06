package com.ruhancomh.myfood.api.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionResponse {

	private String mensagem;
	private LocalDateTime dataHora;
	
}
