package com.ruhancomh.myfood.api.mapper.restaurante;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.restaurante.RestauranteResource;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.model.Restaurante;

@Component
@Lazy
public class FromRestauranteToRestauranteResource
	extends BaseModelMapper<Restaurante, RestauranteResource> {

	public FromRestauranteToRestauranteResource() {
		super(RestauranteResource.class);
	}

}
