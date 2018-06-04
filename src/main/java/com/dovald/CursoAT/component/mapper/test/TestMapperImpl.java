package com.dovald.CursoAT.component.mapper.test;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.question.QuestionMapper;
import com.dovald.CursoAT.component.mapper.tag.TagMapper;
import com.dovald.CursoAT.dto.TestDTO;
import com.dovald.CursoAT.dto.TestGetDTO;
import com.dovald.CursoAT.dto.TestPostDTO;
import com.dovald.CursoAT.dto.TestPutDTO;
import com.dovald.CursoAT.exception.NotFoundException;
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
	public Test dtoToModel(TestPostDTO dto) throws NotFoundException {
		Test model = new Test();
		model.setName(dto.getName());
		if(dto.getIdCourse() != null)
			if(courseService.findById(dto.getIdCourse()).isPresent())
				model.setCourse(courseService.findById(dto.getIdCourse()).get());
			else
				throw new NotFoundException();
		return model;
	}
	
	@Override
	public Test dtoToModel(TestPutDTO dto) throws NotFoundException {
		Test model = new Test();
		model.setName(dto.getName());
		if(dto.getIdCourse()!= null && courseService.findById(dto.getIdCourse()).isPresent())
			model.setCourse(courseService.findById(dto.getIdCourse()).get());
		else {
			if(dto.getIdCourse()!= null)
			throw new NotFoundException();}
		if(dto.getQuestion() != null)model.setQuestion(dto.getQuestion().stream().map(m -> questionService.findById(m.getId()).get() ).collect(Collectors.toList()));
		return model;
	}

	@Override
	public TestDTO modelToDto(Test model) {
		TestDTO dto = new TestDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		if(model.getCourse() != null)dto.setCourse(model.getCourse().getName());
		if(model.getCourse() != null)dto.setIdCourse(model.getCourse().getId());
		return dto;
	}
	
	@Override
	public TestGetDTO modelToGetDto(Test model) {
		TestGetDTO dto = new TestGetDTO();
		dto.setId(model.getId());
		dto.setQuestion(questionMapper.modelToDto(model.getQuestion()));
		return dto;
	}

	@Override
	public List<TestDTO> modelToDto(List<Test> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}

}
