package com.dovald.CursoAT.component.mapper.course;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.CourseDTO;
import com.dovald.CursoAT.model.Course;

@Component
public class CourseMapperImpl extends AbstractMapper<Course, CourseDTO> implements CourseMapper {

	@Override
	public Class<? extends CourseDTO> dtoClazz() {
		return CourseDTO.class;
	}

	@Override
	public Class<? extends Course> modelClazz() {
		return Course.class;
	}

}
