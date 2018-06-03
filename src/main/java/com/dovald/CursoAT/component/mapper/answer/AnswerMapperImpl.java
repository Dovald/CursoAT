package com.dovald.CursoAT.component.mapper.answer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dovald.CursoAT.dto.AnswerDTO;
import com.dovald.CursoAT.dto.AnswerPostDTO;
import com.dovald.CursoAT.model.Answer;
import com.dovald.CursoAT.service.QuestionService;

@Component
public class AnswerMapperImpl implements AnswerMapper {
	
	@Autowired
	QuestionService questionservice;

	@Override
	public Answer dtoToModel(AnswerDTO dto) {
		Answer model = new Answer();
		model.setText(dto.getText());
		return model;
	}

	@Override
	public AnswerDTO modelToDto(Answer model) {
		AnswerDTO dto = new AnswerDTO();
		dto.setId(model.getId());
		dto.setText(model.getText());
		return dto;
	}
	
	@Override
	public AnswerPostDTO modelToPostDto(Answer model) {
		AnswerPostDTO dto = new AnswerPostDTO();
		dto.setId(model.getId());
		dto.setText(model.getText());
		dto.setCorrect(model.isCorrect());
		dto.setIdQuestion(model.getQuestion().getId());
		return dto;
	}

	@Override
	public List<Answer> dtoPostToModel(List<AnswerPostDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}
	
	@Override
	public List<Answer> dtoToModel(List<AnswerDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<AnswerDTO> modelToDto(List<Answer> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}

	@Override
	public List<AnswerPostDTO> modelToPostDto(List<Answer> models) {
		return models.stream().map(m -> modelToPostDto(m)).collect(Collectors.toList());
	}


}
