package com.ruhancomh.myfood.api.request.formaPagamento;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateFormaPagamentoRequest {

	@NotBlank
	private String descricao;
	
}
