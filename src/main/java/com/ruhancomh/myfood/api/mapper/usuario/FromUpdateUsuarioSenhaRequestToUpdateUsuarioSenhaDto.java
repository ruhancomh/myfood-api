package com.ruhancomh.myfood.api.mapper.usuario;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.usuario.UpdateUsuarioSenhaRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.UpdateUsuarioSenhaDto;

@Component
@Lazy
public class FromUpdateUsuarioSenhaRequestToUpdateUsuarioSenhaDto
	implements Mapper<UpdateUsuarioSenhaRequest, UpdateUsuarioSenhaDto>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UpdateUsuarioSenhaDto map(UpdateUsuarioSenhaRequest source) {
		return this.modelMapper.map(source, UpdateUsuarioSenhaDto.class);
	}

}
