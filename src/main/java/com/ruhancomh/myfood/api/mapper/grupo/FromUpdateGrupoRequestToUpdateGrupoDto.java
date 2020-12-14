package com.ruhancomh.myfood.api.mapper.grupo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.grupo.UpdateGrupoRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.UpdateGrupoDto;

@Component
@Lazy
public class FromUpdateGrupoRequestToUpdateGrupoDto
	extends BaseModelMapper<UpdateGrupoRequest, UpdateGrupoDto> {
	
	public FromUpdateGrupoRequestToUpdateGrupoDto() {
		super(UpdateGrupoDto.class);
	}
}
