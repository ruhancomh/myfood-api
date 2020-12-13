package com.ruhancomh.myfood.api.resources.request.usuario;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUsuarioSenhaRequest {

	@NotBlank
	private String senhaAtual;
	
	@NotBlank
	private String novaSenha;
	
}
