package com.ruhancomh.myfood.api.mapper.permissao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.permissao.PermissaoRessource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Permissao;

@Component
@Lazy
public class FromListPermissaoToListPermissaoRessource
	implements Mapper<List<Permissao>, List<PermissaoRessource>>{

	@Autowired
	private ApiPermissaoMapperFactory permissaoMapperFactory;
	
	@Override
	public List<PermissaoRessource> map(List<Permissao> source) {
		return source.stream()
				.map(permissao -> this.permissaoMapperFactory
						.getFromPermissaoToPermissaoResource()
						.map(permissao))
				.collect(Collectors.toList());
	}

}
