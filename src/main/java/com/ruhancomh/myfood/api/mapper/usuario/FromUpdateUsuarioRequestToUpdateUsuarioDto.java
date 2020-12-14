package com.ruhancomh.myfood.api.mapper.usuario;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.usuario.UpdateUsuarioRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.UpdateUsuarioDto;

@Component
@Lazy
public class FromUpdateUsuarioRequestToUpdateUsuarioDto
	extends BaseModelMapper<UpdateUsuarioRequest, UpdateUsuarioDto> {

	public FromUpdateUsuarioRequestToUpdateUsuarioDto() {
		super(UpdateUsuarioDto.class);
	}

}
