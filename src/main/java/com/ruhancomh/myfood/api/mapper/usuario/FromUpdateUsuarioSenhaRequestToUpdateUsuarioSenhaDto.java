package com.ruhancomh.myfood.api.mapper.usuario;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.usuario.UpdateUsuarioSenhaRequest;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.dto.UpdateUsuarioSenhaDto;

@Component
@Lazy
public class FromUpdateUsuarioSenhaRequestToUpdateUsuarioSenhaDto
	extends BaseModelMapper<UpdateUsuarioSenhaRequest, UpdateUsuarioSenhaDto> {

	public FromUpdateUsuarioSenhaRequestToUpdateUsuarioSenhaDto() {
		super(UpdateUsuarioSenhaDto.class);
	}

}
