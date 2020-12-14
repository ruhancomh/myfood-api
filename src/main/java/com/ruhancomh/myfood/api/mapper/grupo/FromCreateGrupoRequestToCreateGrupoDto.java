package com.ruhancomh.myfood.api.mapper.grupo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.grupo.CreateGrupoRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.CreateGrupoDto;

@Component
@Lazy
public class FromCreateGrupoRequestToCreateGrupoDto
	extends BaseModelMapper<CreateGrupoRequest, CreateGrupoDto>{
	
	public FromCreateGrupoRequestToCreateGrupoDto() {
		super(CreateGrupoDto.class);
	}

}