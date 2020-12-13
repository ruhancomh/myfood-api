package com.ruhancomh.myfood.api.mapper.grupo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.grupo.GrupoResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Grupo;

@Component
@Lazy
public class FromGrupoToGrupoResource
	implements Mapper<Grupo, GrupoResource> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public GrupoResource map(Grupo source) {
		return this.modelMapper.map(source, GrupoResource.class);
	}
}
