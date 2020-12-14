package com.ruhancomh.myfood.api.mapper.estado;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ruhancomh.myfood.api.resources.response.estado.UpdateEstadoResponse;
import com.ruhancomh.myfood.core.mapper.BaseModelMapper;
import com.ruhancomh.myfood.domain.model.Estado;

@Component
@Lazy
public class FromEstadoToUpdateEstadoResponse
	extends BaseModelMapper<Estado, UpdateEstadoResponse> {
	
	public FromEstadoToUpdateEstadoResponse() {
		super(UpdateEstadoResponse.class);
	}
}
