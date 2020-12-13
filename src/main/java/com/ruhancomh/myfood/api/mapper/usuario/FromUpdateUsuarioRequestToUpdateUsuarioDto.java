package com.ruhancomh.myfood.api.mapper.usuario;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.usuario.UpdateUsuarioRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.UpdateUsuarioDto;

@Component
@Lazy
public class FromUpdateUsuarioRequestToUpdateUsuarioDto
	implements Mapper<UpdateUsuarioRequest, UpdateUsuarioDto>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UpdateUsuarioDto map(UpdateUsuarioRequest source) {
		return this.modelMapper.map(source, UpdateUsuarioDto.class);
	}

}
