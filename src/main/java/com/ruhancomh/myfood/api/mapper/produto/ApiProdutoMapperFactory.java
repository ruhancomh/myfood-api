package com.ruhancomh.myfood.api.mapper.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ApiProdutoMapperFactory {

	@Autowired
	@Lazy
	private FromProdutoToSimpleProdutoResource fromProdutoToSimpleProdutoResource;
	
	@Autowired
	@Lazy
	private FromListProdutoToListSimpleProdutoResource fromListProdutoToListSimpleProdutoResource;
	
	@Autowired
	@Lazy
	private FromCreateProdutoRequestToCreateProdutoDto fromCreateProdutoRequestToCreateProdutoDto;
	
	@Autowired
	@Lazy
	private FromUpdateProdutoRequestToUpdateProdutoDto fromUpdateProdutoRequestToUpdateProdutoDto;
}
