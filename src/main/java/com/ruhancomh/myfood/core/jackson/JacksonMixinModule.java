package com.ruhancomh.myfood.core.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ruhancomh.myfood.api.model.mixin.CidadeMixin;
import com.ruhancomh.myfood.api.model.mixin.CozinhaMixin;
import com.ruhancomh.myfood.api.model.mixin.RestauranteMixin;
import com.ruhancomh.myfood.domain.model.Cidade;
import com.ruhancomh.myfood.domain.model.Cozinha;
import com.ruhancomh.myfood.domain.model.Restaurante;

@Component
public class JacksonMixinModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public JacksonMixinModule() {
		setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
	}
	
}
