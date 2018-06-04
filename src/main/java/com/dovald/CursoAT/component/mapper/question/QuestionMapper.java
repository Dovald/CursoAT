package com.dovald.CursoAT.component.mapper.question;

import java.util.List;

import com.dovald.CursoAT.dto.QuestionDTO;
import com.dovald.CursoAT.dto.QuestionPostDTO;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Question;

public interface QuestionMapper{
	
	public Question dtoToModel(QuestionDTO dto);
	public QuestionDTO modelToDto(Question model);
	public QuestionPostDTO modelToDtoPost(Question model);
	public List<Question> dtoToModel(List<QuestionDTO> dtos);
	public List<QuestionDTO> modelToDto(List<Question> models);
	public Question dtoToModel(QuestionPostDTO dto) throws NotFoundException;

}
