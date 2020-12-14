package com.ruhancomh.myfood.api.mapper.usuario;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.usuario.CreateUsuarioRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.CreateUsuarioDto;

@Component
@Lazy
public class FromCreateUsuarioRequestToCreateUsuarioDto
	extends BaseModelMapper<CreateUsuarioRequest, CreateUsuarioDto> {

	public FromCreateUsuarioRequestToCreateUsuarioDto() {
		super(CreateUsuarioDto.class);
	}

}
