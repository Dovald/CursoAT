package com.dovald.CursoAT.component.mapper.difficulty;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.DifficultyDTO;
import com.dovald.CursoAT.model.Difficulty;

@Component
public class DifficultyMapperImpl extends AbstractMapper<Difficulty,DifficultyDTO> implements DifficultyMapper {

	@Override
	public Class<? extends DifficultyDTO> dtoClazz() {
		return DifficultyDTO.class;
	}

	@Override
	public Class<? extends Difficulty> modelClazz() {
		return Difficulty.class;
	}

}
