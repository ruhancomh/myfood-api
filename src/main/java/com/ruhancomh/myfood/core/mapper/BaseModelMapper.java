package com.ruhancomh.myfood.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseModelMapper<S, T> implements Mapper<S, T> {

	private Class<T> destinationType;
	
	public BaseModelMapper(Class<T> destinationType) {
		this.destinationType = destinationType;
	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public T map(S source) {
		return this.modelMapper.map(source, this.destinationType);
	}

}
