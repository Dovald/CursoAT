package com.dovald.CursoAT.component.mapper.answer;

import java.util.List;

import com.dovald.CursoAT.dto.AnswerDTO;
import com.dovald.CursoAT.dto.AnswerPostDTO;
import com.dovald.CursoAT.model.Answer;

public interface AnswerMapper {
	
	public Answer dtoToModel(AnswerDTO dto);
	public Answer dtoToModel(AnswerPostDTO dto);
	public AnswerDTO modelToDto(Answer model);
	public List<Answer> dtoToModel(List<AnswerDTO> dtos);
	public List<AnswerDTO> modelToDto(List<Answer> models);

}
