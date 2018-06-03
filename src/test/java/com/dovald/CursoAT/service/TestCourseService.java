package com.dovald.CursoAT.service;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.dovald.CursoAT.dao.CourseDAO;
import com.dovald.CursoAT.model.Course;
import com.dovald.CursoAT.model.User;

@RunWith(MockitoJUnitRunner.class)
public class TestCourseService {
	
	@InjectMocks
	CourseService service = new CourseServiceImpl();
	
	@Mock
	CourseDAO dao;
	
	@Test
	public void testCreate() {
		final Course course = new Course();
		course.setId(1);
		course.setName("Testing");
		course.setStart_date(new Date());
		course.setEnd_date(new Date());
		course.setUser(new ArrayList<User>());
		
		Mockito.when(dao.save(course)).thenReturn(course);
		final Course res = service.create(course);
		
		Assert.assertEquals(res.getName(), course.getName());
		Assert.assertNotNull(res.getId());
		Assert.assertTrue(res.getUser().isEmpty());
		Assert.assertNotNull(res.getStart_date());
		Assert.assertNotNull(res.getEnd_date());
	}


}
