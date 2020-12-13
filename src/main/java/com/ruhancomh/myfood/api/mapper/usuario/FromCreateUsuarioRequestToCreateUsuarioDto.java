package com.ruhancomh.myfood.api.mapper.usuario;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.usuario.CreateUsuarioRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.CreateUsuarioDto;

@Component
@Lazy
public class FromCreateUsuarioRequestToCreateUsuarioDto
	implements Mapper<CreateUsuarioRequest, CreateUsuarioDto>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CreateUsuarioDto map(CreateUsuarioRequest source) {
		return this.modelMapper.map(source, CreateUsuarioDto.class);
	}

}
