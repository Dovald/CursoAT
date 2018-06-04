package com.dovald.CursoAT.component.mapper.question;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.answer.AnswerMapper;
import com.dovald.CursoAT.component.mapper.difficulty.DifficultyMapper;
import com.dovald.CursoAT.component.mapper.tag.TagMapper;
import com.dovald.CursoAT.dto.QuestionDTO;
import com.dovald.CursoAT.dto.QuestionPostDTO;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Difficulty;
import com.dovald.CursoAT.model.Question;
import com.dovald.CursoAT.model.Tag;
import com.dovald.CursoAT.service.DifficultyService;
import com.dovald.CursoAT.service.TagService;

@Component
public class QuestionMapperImpl  implements QuestionMapper {
	
	@Autowired
	AnswerMapper answerMapper;
	
	@Autowired
	TagMapper tagMapper;
	
	@Autowired
	DifficultyMapper difficultyMapper;
	
	@Autowired
	TagService tagService;
	
	@Autowired
	DifficultyService difficultyService;
	
	public Question dtoToModel(QuestionDTO dto) {
		Question model = new Question();
		model.setTag(tagService.findById(dto.getTag().getId()).get());
		model.setDifficulty(difficultyService.findById(dto.getDifficulty().getId()).get());
		model.setText(dto.getText());
		model.setAnswer(answerMapper.dtoToModel(dto.getAnswer()));
		return model;
	}
	
	@Override
	public Question dtoToModel(QuestionPostDTO dto) throws NotFoundException {
		Question model = new Question();
		Optional<Tag> tag = tagService.findById(dto.getTag().getId());
		if(!tag.isPresent()) throw new NotFoundException();
		Optional<Difficulty> difficulty = difficultyService.findById(dto.getDifficulty().getId());
		if(!difficulty.isPresent()) throw new NotFoundException();
		model.setTag(tag.get());
		model.setDifficulty(difficulty.get());
		model.setText(dto.getText());
		return model;
	}
	
	public QuestionDTO modelToDto(Question model) {
		QuestionDTO dto = new QuestionDTO();
		dto.setId(model.getId());
		dto.setTag(tagMapper.modelToDto(model.getTag()));
		dto.setDifficulty(difficultyMapper.modelToDto(model.getDifficulty()));
		dto.setText(model.getText());
		dto.setAnswer(answerMapper.modelToDto(model.getAnswer()));
		return dto;		
	}
	
	public QuestionPostDTO modelToDtoPost(Question model) {
		QuestionPostDTO dto = new QuestionPostDTO();
		dto.setId(model.getId());
		dto.setTag(tagMapper.modelToDto(model.getTag()));
		dto.setDifficulty(difficultyMapper.modelToDto(model.getDifficulty()));
		dto.setText(model.getText());
		return dto;		
	}
	
	public List<Question> dtoToModel(List<QuestionDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	public List<QuestionDTO> modelToDto(List<Question> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}

}
