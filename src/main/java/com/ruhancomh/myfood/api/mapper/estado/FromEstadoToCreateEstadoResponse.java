package com.ruhancomh.myfood.api.mapper.estado;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.estado.CreateEstadoResponse;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.model.Estado;

@Component
@Lazy
public class FromEstadoToCreateEstadoResponse
	extends BaseModelMapper<Estado, CreateEstadoResponse> {

	public FromEstadoToCreateEstadoResponse() {
		super(CreateEstadoResponse.class);
	}
	
}
