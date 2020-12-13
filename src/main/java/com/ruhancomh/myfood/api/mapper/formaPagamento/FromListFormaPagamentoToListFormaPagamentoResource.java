package com.ruhancomh.myfood.api.mapper.formaPagamento;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.formaPagamento.FormaPagamentoResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.FormaPagamento;

@Component
@Lazy
public class FromListFormaPagamentoToListFormaPagamentoResource 
	implements Mapper<List<FormaPagamento>, List<FormaPagamentoResource>> {

	@Autowired
	@Lazy
	private ApiFormaPagamentoMapperFactory formaPagamentoMapperFactoy;
	
	@Override
	public List<FormaPagamentoResource> map(List<FormaPagamento> source) {
		return source.stream()
				.map(formaPagamento -> this.formaPagamentoMapperFactoy
					.getFromFormaPagamentoToFormaPagamentoResource()
					.map(formaPagamento))
				.collect(Collectors.toList());
	}

}
