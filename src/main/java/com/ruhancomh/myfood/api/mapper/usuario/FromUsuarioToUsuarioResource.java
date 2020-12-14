package com.ruhancomh.myfood.api.mapper.usuario;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.usuario.UsuarioResource;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.model.Usuario;

@Component
@Lazy
public class FromUsuarioToUsuarioResource
	extends BaseModelMapper<Usuario, UsuarioResource> {

	public FromUsuarioToUsuarioResource() {
		super(UsuarioResource.class);
	}
	
}
