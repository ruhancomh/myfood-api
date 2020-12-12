package com.ruhancomh.myfood.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ruhancomh.myfood.domain.model.Estado;

public abstract class CidadeMixin {
	
	@JsonIgnoreProperties(value = "nome", allowGetters = true)
	private Estado estado;
	
}
