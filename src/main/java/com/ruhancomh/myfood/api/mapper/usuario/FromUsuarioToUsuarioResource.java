package com.ruhancomh.myfood.api.mapper.usuario;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.usuario.UsuarioResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Usuario;

@Component
@Lazy
public class FromUsuarioToUsuarioResource
	implements Mapper<Usuario, UsuarioResource>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UsuarioResource map(Usuario source) {
		return this.modelMapper.map(source, UsuarioResource.class);
	}

}
