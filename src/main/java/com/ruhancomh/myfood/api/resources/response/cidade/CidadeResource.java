package com.ruhancomh.myfood.api.resources.response.cidade;

import com.ruhancomh.myfood.api.resources.response.estado.EstadoResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeResource {

	private Long id;
	private String nome;
	private EstadoResource estado;
	
}
