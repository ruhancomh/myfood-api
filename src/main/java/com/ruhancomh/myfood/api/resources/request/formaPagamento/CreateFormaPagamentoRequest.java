package com.ruhancomh.myfood.api.resources.request.formaPagamento;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFormaPagamentoRequest {
	
	@NotBlank
	private String descricao;
	
}
