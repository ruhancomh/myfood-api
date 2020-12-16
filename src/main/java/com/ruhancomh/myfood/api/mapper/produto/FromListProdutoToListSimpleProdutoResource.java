package com.ruhancomh.myfood.api.mapper.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.produto.SimpleProdutoResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.Produto;

@Component
@Lazy
public class FromListProdutoToListSimpleProdutoResource 
	implements Mapper<List<Produto>, List<SimpleProdutoResource>>{

	@Autowired
	@Lazy
	private ApiProdutoMapperFactory produtoMapperFactory;

	@Override
	public List<SimpleProdutoResource> map(List<Produto> source) {
		return source.stream()
				.map(produto -> this.produtoMapperFactory
						.getFromProdutoToSimpleProdutoResource()
						.map(produto))
				.collect(Collectors.toList());
	}
	
}
