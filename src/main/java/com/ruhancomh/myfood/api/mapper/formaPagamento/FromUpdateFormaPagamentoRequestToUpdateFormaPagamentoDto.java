package com.ruhancomh.myfood.api.mapper.formaPagamento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.request.formaPagamento.UpdateFormaPagamentoRequest;
import com.ruhancomh.myfood.core.mapper.Mapper;
import com.ruhancomh.myfood.domain.dto.UpdateFormaPagamentoDto;

@Component
public class FromUpdateFormaPagamentoRequestToUpdateFormaPagamentoDto
	implements Mapper<UpdateFormaPagamentoRequest, UpdateFormaPagamentoDto>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UpdateFormaPagamentoDto map(UpdateFormaPagamentoRequest source) {
		return this.modelMapper.map(source, UpdateFormaPagamentoDto.class);
	}

}
