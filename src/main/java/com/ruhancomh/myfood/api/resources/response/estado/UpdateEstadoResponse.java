package com.ruhancomh.myfood.api.resources.response.estado;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEstadoResponse {

	private Long id;
	private String nome;
	
}
