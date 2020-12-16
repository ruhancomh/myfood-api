package com.ruhancomh.myfood.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProdutoDto {

	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Boolean ativo;
	
}
