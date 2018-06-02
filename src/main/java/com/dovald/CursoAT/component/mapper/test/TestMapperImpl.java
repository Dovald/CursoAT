package com.dovald.CursoAT.component.mapper.test;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.question.QuestionMapper;
import com.dovald.CursoAT.component.mapper.tag.TagMapper;
import com.dovald.CursoAT.dto.TestDTO;
import com.dovald.CursoAT.dto.TestPostDTO;
import com.dovald.CursoAT.dto.TestPutDTO;
import com.dovald.CursoAT.model.Test;
import com.dovald.CursoAT.service.CourseService;
import com.dovald.CursoAT.service.QuestionService;

@Component
public class TestMapperImpl implements TestMapper {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	TagMapper tagMapper;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@Override
	public Test dtoToModel(TestPostDTO dto) {
		Test model = new Test();
		model.setName(dto.getName());
		model.setCourse(courseService.findById(dto.getIdCourse()).get());
		return model;
	}
	
	@Override
	public Test dtoToModel(TestPutDTO dto) {
		Test model = new Test();
		model.setName(dto.getName());
		model.setCourse(courseService.findById(dto.getIdCourse()).get());
		model.setQuestion(dto.getQuestion().stream().map(m -> questionService.findById(m.getId()).get() ).collect(Collectors.toList()));
		return model;
	}

	@Override
	public TestDTO modelToDto(Test model) {
		TestDTO dto = new TestDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setCourse(model.getCourse().getName());
		dto.setIdCourse(model.getCourse().getId());
		return dto;
	}

	@Override
	public List<TestDTO> modelToDto(List<Test> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}

}
