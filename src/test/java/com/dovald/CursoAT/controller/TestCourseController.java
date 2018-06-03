package com.dovald.CursoAT.controller;

import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.RequestBody;

import com.dovald.CursoAT.dto.CourseDTO;
import com.dovald.CursoAT.dto.UserDTO;
import com.dovald.CursoAT.model.User;

@RunWith(MockitoJUnitRunner.class)
public class TestCourseController {
	
	@InjectMocks
	CourseController controller = new CourseController();
	
	@Mock
	DozerBeanMapper dozer;
	
	@Test
	public void Testcreate(CourseDTO dto) 
	{
		final User user = new User();
		final UserDTO userDTO = new UserDTO();
		userDTO.setName("Pepe");
		Mockito.when(dozer.map(userDTO, User.class)).thenReturn(user);		
		final User res = mapper.dtoToModel(userDTO);
		Assert.assertEquals(res, user);		
	}

}
