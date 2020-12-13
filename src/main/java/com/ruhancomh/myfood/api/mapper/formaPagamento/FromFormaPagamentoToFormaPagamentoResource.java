package com.ruhancomh.myfood.api.mapper.formaPagamento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.formaPagamento.FormaPagamentoResource;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.model.FormaPagamento;

@Component
@Lazy
public class FromFormaPagamentoToFormaPagamentoResource implements Mapper<FormaPagamento, FormaPagamentoResource> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public FormaPagamentoResource map(FormaPagamento source) {
		return this.modelMapper.map(source, FormaPagamentoResource.class);
	}

}
