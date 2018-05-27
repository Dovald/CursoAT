package com.dovald.CursoAT.component.mapper.question;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.QuestionDTO;
import com.dovald.CursoAT.model.Question;

@Component
public class QuestionMapperImpl extends AbstractMapper<Question,QuestionDTO> implements QuestionMapper {

	@Override
	public Class<? extends QuestionDTO> dtoClazz() {
		return QuestionDTO.class;
	}

	@Override
	public Class<? extends Question> modelClazz() {
		return Question.class;
	}

}
