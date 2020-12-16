package com.ruhancomh.myfood.api.resources.response.produto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleProdutoResource {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private boolean ativo;
	
}
