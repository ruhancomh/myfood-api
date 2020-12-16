package com.ruhancomh.myfood.api.resources.request.produto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProdutoRequest {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@PositiveOrZero
	@NotNull
	private BigDecimal preco;
	
	@NotNull
	private Boolean ativo;
	
}
