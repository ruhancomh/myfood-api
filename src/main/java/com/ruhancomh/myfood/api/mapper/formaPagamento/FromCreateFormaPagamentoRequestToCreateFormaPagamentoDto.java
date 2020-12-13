package com.ruhancomh.myfood.api.mapper.formaPagamento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.request.formaPagamento.CreateFormaPagamentoRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.CreateFormaPagamentoDto;

@Component
public class FromCreateFormaPagamentoRequestToCreateFormaPagamentoDto
	implements Mapper<CreateFormaPagamentoRequest, CreateFormaPagamentoDto> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CreateFormaPagamentoDto map(CreateFormaPagamentoRequest source) {
		return this.modelMapper.map(source, CreateFormaPagamentoDto.class);
	}

}
