package com.ruhancomh.myfood.api.mapper.restaurante;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.restaurante.RestauranteResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Restaurante;

@Component
@Lazy
public class FromListRestauranteToListRestauranteResource 
	implements Mapper<List<Restaurante>, List<RestauranteResource>>{
	
	@Autowired
	@Lazy
	private ApiRestauranteMapperFactory resturanteMapperFactory;
	
	@Override
	public List<RestauranteResource> map(List<Restaurante> source) {
		return source.stream()
				.map(restaurante -> this.resturanteMapperFactory
						.getFromRestauranteToRestauranteResource()
						.map(restaurante))
				.collect(Collectors.toList());
	}

}
