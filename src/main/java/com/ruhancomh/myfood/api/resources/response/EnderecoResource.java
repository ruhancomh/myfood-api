package com.ruhancomh.myfood.api.resources.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResource {

	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidadeNome;
	private String cidadeEstadoNome;
	
}
