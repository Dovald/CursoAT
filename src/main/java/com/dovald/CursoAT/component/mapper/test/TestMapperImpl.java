package com.dovald.CursoAT.component.mapper.test;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.tag.TagMapper;
import com.dovald.CursoAT.dto.TestDTO;
import com.dovald.CursoAT.dto.TestPostDTO;
import com.dovald.CursoAT.model.Test;
import com.dovald.CursoAT.service.CourseService;

@Component
public class TestMapperImpl implements TestMapper {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	TagMapper tagMapper;

	@Override
	public Test dtoToModel(TestDTO dto) {
		Test model = new Test();
		model.setName(dto.getName());
		return model;
	}
	
	@Override
	public Test dtoToModel(TestPostDTO dto) {
		Test model = new Test();
		model.setName(dto.getName());
		model.setTag(tagMapper.dtoToModel(dto.getTag()));
		model.setCourse(courseService.findById(dto.getCourse().getId()).get());
		return model;
	}

	@Override
	public TestDTO modelToDto(Test model) {
		TestDTO dto = new TestDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		return dto;
	}

	@Override
	public List<Test> dtoToModel(List<TestDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<TestDTO> modelToDto(List<Test> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}

}
