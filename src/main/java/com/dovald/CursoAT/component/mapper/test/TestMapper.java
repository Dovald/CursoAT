package com.dovald.CursoAT.component.mapper.test;

import java.util.List;

import com.dovald.CursoAT.dto.TestDTO;
import com.dovald.CursoAT.dto.TestPostDTO;
import com.dovald.CursoAT.model.Test;

public interface TestMapper {
	
	public Test dtoToModel(TestPostDTO dto);
	public TestDTO modelToDto(Test model);
	public List<TestDTO> modelToDto(List<Test> models);

}
