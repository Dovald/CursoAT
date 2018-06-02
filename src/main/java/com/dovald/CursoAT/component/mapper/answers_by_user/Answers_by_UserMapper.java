package com.dovald.CursoAT.component.mapper.answers_by_user;

import java.util.List;

import com.dovald.CursoAT.dto.Answers_by_UserDTO;
import com.dovald.CursoAT.model.Answers_by_User;

public interface Answers_by_UserMapper {
	
	public  Answers_by_User dtoToModel(Integer idTest, Integer idUser, Answers_by_UserDTO dto);
	public  List<Answers_by_User> dtoToModel(Integer idTest, Integer idUser, List<Answers_by_UserDTO> dtos);

}
