package com.dovald.CursoAT.component.mapper.answer;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.AnswerDTO;
import com.dovald.CursoAT.model.Answer;

@Component
public class AnswerMapperImpl extends AbstractMapper<Answer, AnswerDTO> implements AnswerMapper {

	@Override
	public Class<? extends AnswerDTO> dtoClazz() {
		return AnswerDTO.class;
	}

	@Override
	public Class<? extends Answer> modelClazz() {
		return Answer.class;
	}

}
