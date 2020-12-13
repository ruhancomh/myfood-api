package com.ruhancomh.myfood.api.resources.request.restaurante;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRestauranteRequest {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@PositiveOrZero
	private BigDecimal taxaFrete;
	
	@NotNull
	private Long cozinhaId;
	
	@NotNull
	@Valid
	private CreateRestauranteRequest.Endereco endereco;
	
	@Getter
	@Setter
	public class Endereco {
		
		@NotBlank
		private String cep;
		
		@NotBlank
		private String logradouro;
		
		@NotBlank
		private String numero;
		
		private String complemento;
		
		@NotBlank
		private String bairro;
		
		@NotNull
		private Long cidadeId;
		
	}
	
}
