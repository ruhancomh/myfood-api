package com.ruhancomh.myfood.api.mapper.grupo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.grupo.UpdateGrupoRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.UpdateGrupoDto;

@Component
@Lazy
public class FromUpdateGrupoRequestToUpdateGrupoDto
	implements Mapper<UpdateGrupoRequest, UpdateGrupoDto>{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UpdateGrupoDto map(UpdateGrupoRequest source) {
		return this.modelMapper.map(source, UpdateGrupoDto.class);
	}
}
