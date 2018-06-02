package com.dovald.CursoAT.component.mapper.answers_by_user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dovald.CursoAT.dto.Answers_by_UserDTO;
import com.dovald.CursoAT.model.Answers_by_User;
import com.dovald.CursoAT.service.AnswerService;
import com.dovald.CursoAT.service.TestService;

@Component
public class Answers_by_UserMapperImpl implements Answers_by_UserMapper {
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	TestService testService;

	@Override
	public Answers_by_User dtoToModel(Answers_by_UserDTO dto) {
		Answers_by_User model = new Answers_by_User();
		model.setQuestion(dto.getQuestion());
		model.setAnswer(dto.getAnswer().getText());
		model.setIdUser(dto.getIdUser());
		model.setIdTest(dto.getIdTest());
		model.setCorrect(answerService.findById(dto.getAnswer().getId()).get().isCorrect());
		model.setDate(dto.getDate());
		return model;
	}
	
	public List<Answers_by_User> dtoToModel(List<Answers_by_UserDTO> dtos)
	{
		List<Answers_by_User> models = new ArrayList<Answers_by_User>();
		dtos.forEach(m -> models.add(dtoToModel(m)));
		return models;		
	}


}
