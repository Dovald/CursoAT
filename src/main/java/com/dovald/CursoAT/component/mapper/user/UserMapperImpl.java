package com.dovald.CursoAT.component.mapper.user;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.UserDTO;
import com.dovald.CursoAT.model.User;

@Component
public class UserMapperImpl extends AbstractMapper<User, UserDTO> implements UserMapper {

	@Override
	public Class<? extends UserDTO> dtoClazz() {
		return UserDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}

}
