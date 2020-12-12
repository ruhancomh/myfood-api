package com.ruhancomh.myfood.api.model.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruhancomh.myfood.domain.model.Restaurante;

public abstract class CozinhaMixin {

	@JsonIgnore
	private List<Restaurante> restaurantes;
	
}
