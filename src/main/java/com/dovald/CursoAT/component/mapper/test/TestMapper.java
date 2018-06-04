package com.dovald.CursoAT.component.mapper.test;

import java.util.List;

import com.dovald.CursoAT.dto.TestDTO;
import com.dovald.CursoAT.dto.TestGetDTO;
import com.dovald.CursoAT.dto.TestPostDTO;
import com.dovald.CursoAT.dto.TestPutDTO;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Test;

public interface TestMapper {
	
	public Test dtoToModel(TestPostDTO dto) throws NotFoundException;
	public Test dtoToModel(TestPutDTO dto) throws NotFoundException;
	public TestDTO modelToDto(Test model);
	public TestGetDTO modelToGetDto(Test model);
	public List<TestDTO> modelToDto(List<Test> models);
	

}
