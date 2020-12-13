package com.ruhancomh.myfood.api.resources.response.restaurante;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.ruhancomh.myfood.api.resources.response.EnderecoResource;
import com.ruhancomh.myfood.api.resources.response.cozinha.SimpleCozinhaResource;
import com.ruhancomh.myfood.api.resources.response.formaPagamento.FormaPagamentoResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteResource {

	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private SimpleCozinhaResource cozinha;
	private EnderecoResource endereco;
	private Boolean ativo;
	private OffsetDateTime dataCadastro;
	private OffsetDateTime dataAtualizacao;
	private List<FormaPagamentoResource> formasPagamento;
	
}
