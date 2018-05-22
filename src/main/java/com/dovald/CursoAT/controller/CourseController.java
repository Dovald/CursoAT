package com.dovald.CursoAT.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dovald.CursoAT.component.mapper.course.CourseMapper;
import com.dovald.CursoAT.dto.CourseDTO;
import com.dovald.CursoAT.model.Course;
import com.dovald.CursoAT.service.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseMapper courseMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<CourseDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Course> users = courseService.findAll(PageRequest.of(page, size));
		return courseMapper.modelToDto(users);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public CourseDTO findById(@PathVariable Integer id) {
		final Optional<Course> user = courseService.findById(id);
		return courseMapper.modelToDto(user.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public CourseDTO create(@RequestBody CourseDTO dto) {
		final Course user = courseMapper.dtoToModel(dto);
		final Course createUser = courseService.create(user);
		return courseMapper.modelToDto(createUser);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody CourseDTO dto) {
		final Course user = courseMapper.dtoToModel(dto);
		courseService.update(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody CourseDTO dto) {
		final Course user = courseMapper.dtoToModel(dto);
		courseService.delete(user);
	}

}
