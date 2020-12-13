package com.ruhancomh.myfood.api.mapper.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.usuario.UsuarioResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Usuario;

@Component
@Lazy
public class FromListUsuarioToListUsuarioResource
	implements Mapper<List<Usuario>, List<UsuarioResource>>{
	
	@Autowired
	@Lazy
	private ApiUsuarioMapperFactory usuarioMapperFactory;

	@Override
	public List<UsuarioResource> map(List<Usuario> source) {
		return source.stream()
				.map(usuario -> this.usuarioMapperFactory
						.getFromUsuarioToUsuarioResource()
						.map(usuario))
				.collect(Collectors.toList());
	}

}
