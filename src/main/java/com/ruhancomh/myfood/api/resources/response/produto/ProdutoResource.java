package com.ruhancomh.myfood.api.resources.response.produto;

import java.math.BigDecimal;

import com.ruhancomh.myfood.api.resources.response.restaurante.RestauranteResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResource {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private boolean ativo;
	private RestauranteResource restaurante;
	
}
