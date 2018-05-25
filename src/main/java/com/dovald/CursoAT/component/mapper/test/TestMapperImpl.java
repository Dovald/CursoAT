package com.dovald.CursoAT.component.mapper.test;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.TestDTO;
import com.dovald.CursoAT.model.Test;

@Component
public class TestMapperImpl extends AbstractMapper<Test,TestDTO> implements TestMapper {

	@Override
	public Class<? extends TestDTO> dtoClazz() {
		return TestDTO.class;
	}

	@Override
	public Class<? extends Test> modelClazz() {
		return Test.class;
	}

}
