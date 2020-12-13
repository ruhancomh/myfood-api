package com.ruhancomh.myfood.api.mapper.grupo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.grupo.CreateGrupoRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.CreateGrupoDto;

@Component
@Lazy
public class FromCreateGrupoRequestToCreateGrupoDto
	implements Mapper<CreateGrupoRequest, CreateGrupoDto>{
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CreateGrupoDto map(CreateGrupoRequest source) {
		return this.modelMapper.map(source, CreateGrupoDto.class);
	}
}