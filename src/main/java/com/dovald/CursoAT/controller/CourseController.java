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
import com.dovald.CursoAT.exception.NotFoundException;
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
		final Set<Course> courses = courseService.findAll(PageRequest.of(page, size));
		return courseMapper.modelToDto(courses);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public CourseDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Course> course = courseService.findById(id);
		if(!course.isPresent()) throw new NotFoundException();
		return courseMapper.modelToDto(course.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public CourseDTO create(@RequestBody CourseDTO dto) {
		final Course course = courseMapper.dtoToModel(dto);
		final Course createCourse = courseService.create(course);
		return courseMapper.modelToDto(createCourse);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody CourseDTO dto) throws NotFoundException {
		final Optional<Course> course = courseService.findById(id);
		if(!course.isPresent()) throw new NotFoundException();
		final Course course1 = courseMapper.dtoToModel(dto);
		course.get().setName(course1.getName());
		courseService.update(course.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Course> course = courseService.findById(id);
		if(!course.isPresent()) throw new NotFoundException();
		courseService.delete(course.get());
	}

}
