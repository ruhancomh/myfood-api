package com.ruhancomh.myfood.api.resources.request.grupo;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateGrupoRequest {

	@NotBlank
	private String nome;
	
}
