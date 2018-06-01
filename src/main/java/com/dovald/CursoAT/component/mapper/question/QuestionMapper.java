package com.dovald.CursoAT.component.mapper.question;

import java.util.Set;

import com.dovald.CursoAT.dto.QuestionDTO;
import com.dovald.CursoAT.model.Question;

public interface QuestionMapper{
	
	public Question dtoToModel(QuestionDTO dto);
	public QuestionDTO modelToDto(Question model);
	public Set<Question> dtoToModel(Set<QuestionDTO> dtos);
	public Set<QuestionDTO> modelToDto(Set<Question> models);

}
