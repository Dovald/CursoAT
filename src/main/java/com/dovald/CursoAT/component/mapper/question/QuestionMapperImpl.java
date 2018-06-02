package com.dovald.CursoAT.component.mapper.question;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.answer.AnswerMapper;
import com.dovald.CursoAT.dto.QuestionDTO;
import com.dovald.CursoAT.model.Question;
import com.dovald.CursoAT.service.DifficultyService;
import com.dovald.CursoAT.service.TagService;

@Component
public class QuestionMapperImpl  implements QuestionMapper {

	@Autowired
	TagService tagService;
	
	@Autowired
	DifficultyService difficultyService;
	
	@Autowired
	AnswerMapper mapper;
	
	public Question dtoToModel(QuestionDTO dto) {
		Question model = new Question();
		model.setTag(tagService.findOneByName(dto.getTag()).get());
		model.setDifficulty(difficultyService.findOneByName(dto.getDifficulty()).get());
		model.setText(dto.getText());
		model.setAnswer(mapper.dtoToModel(dto.getAnswer()));
		return model;
	}
	
	public QuestionDTO modelToDto(Question model) {
		QuestionDTO dto = new QuestionDTO();
		dto.setId(model.getId());
		dto.setTag(model.getTag().getName());
		dto.setDifficulty(model.getDifficulty().getName());
		dto.setText(model.getText());
		dto.setAnswer(mapper.modelToDto(model.getAnswer()));
		return dto;		
	}
	
	public List<Question> dtoToModel(List<QuestionDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	public List<QuestionDTO> modelToDto(List<Question> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}

}
