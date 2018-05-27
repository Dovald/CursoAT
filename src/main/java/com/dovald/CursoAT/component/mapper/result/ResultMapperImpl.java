package com.dovald.CursoAT.component.mapper.result;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.ResultDTO;
import com.dovald.CursoAT.model.Result;

@Component
public class ResultMapperImpl extends AbstractMapper<Result,ResultDTO> implements ResultMapper {

	@Override
	public Class<? extends ResultDTO> dtoClazz() {
		return ResultDTO.class;
	}

	@Override
	public Class<? extends Result> modelClazz() {
		return Result.class;
	}

}
