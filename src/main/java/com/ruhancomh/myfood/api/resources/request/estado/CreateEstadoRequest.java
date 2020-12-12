package com.ruhancomh.myfood.api.resources.request.estado;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEstadoRequest {

	@NotBlank
	public String nome;
	
}
