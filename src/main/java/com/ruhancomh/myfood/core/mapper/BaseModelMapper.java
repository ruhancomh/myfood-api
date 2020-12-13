package com.ruhancomh.myfood.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseModelMapper<S, T> implements Mapper<S, T> {

	private Class<T> classType;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public T map(S source) {
		return this.modelMapper.map(source, this.classType);
	}

}
