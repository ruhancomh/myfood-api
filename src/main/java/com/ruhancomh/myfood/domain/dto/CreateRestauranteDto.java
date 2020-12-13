package com.ruhancomh.myfood.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CreateRestauranteDto {
	
	private String nome;
	private BigDecimal taxaFrete;
	private Long cozinhaId;
	private CreateRestauranteDto.Endereco endereco;
	
	@Getter
	@Setter
	@NoArgsConstructor
	public static class Endereco {
		
		private String cep;
		private String logradouro;
		private String numero;
		private String complemento;
		private String bairro;
		private Long cidadeId;
		
	}
	
}
