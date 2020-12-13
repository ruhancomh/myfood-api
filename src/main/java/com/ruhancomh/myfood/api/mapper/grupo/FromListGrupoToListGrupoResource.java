package com.ruhancomh.myfood.api.mapper.grupo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.grupo.GrupoResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Grupo;

@Component
@Lazy
public class FromListGrupoToListGrupoResource
	implements Mapper<List<Grupo>, List<GrupoResource>>{

	@Autowired
	@Lazy
	private ApiGrupoMapperFactory grupoMapperFactory;
	
	@Override
	public List<GrupoResource> map(List<Grupo> source) {
		return source.stream()
				.map(grupo -> this.grupoMapperFactory
						.getFromGrupoToGrupoResource()
						.map(grupo))
				.collect(Collectors.toList());
	}

}
