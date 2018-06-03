package com.dovald.CursoAT.component.mapper.answer;

import java.util.List;

import com.dovald.CursoAT.dto.AnswerDTO;
import com.dovald.CursoAT.dto.AnswerPostDTO;
import com.dovald.CursoAT.model.Answer;

public interface AnswerMapper {
	
	public Answer dtoToModel(AnswerDTO dto);
	public AnswerDTO modelToDto(Answer model);
	public AnswerPostDTO modelToPostDto(Answer model);
	public List<AnswerDTO> modelToDto(List<Answer> models);
	public List<AnswerPostDTO> modelToPostDto(List<Answer> models);
	public List<Answer> dtoToModel(List<AnswerDTO> dtos);
	public List<Answer> dtoPostToModel(List<AnswerPostDTO> dtos);

}
