package com.dovald.CursoAT.service;

import java.util.List;

import com.dovald.CursoAT.model.Answers_by_User;
import com.dovald.CursoAT.model.Result;

public interface Answers_by_UserService extends AbstractCRUDService<Answers_by_User, Integer> {
	
	Result submitTest(List<Answers_by_User> list);

}
