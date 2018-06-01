package com.dovald.CursoAT.component.mapper.answers_by_user;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.Answers_by_UserDTO;
import com.dovald.CursoAT.model.Answers_by_User;

@Component
public class Answers_by_UserMapperImpl extends AbstractMapper<Answers_by_User, Answers_by_UserDTO> implements Answers_by_UserMapper {

	@Override
	public Class<? extends Answers_by_UserDTO> dtoClazz() {
		return Answers_by_UserDTO.class;
	}

	@Override
	public Class<? extends Answers_by_User> modelClazz() {
		return Answers_by_User.class;
	}

}
