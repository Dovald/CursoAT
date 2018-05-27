package com.dovald.CursoAT.component.mapper.tag;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.component.mapper.AbstractMapper;
import com.dovald.CursoAT.dto.TagDTO;
import com.dovald.CursoAT.model.Tag;

@Component
public class TagMapperImpl extends AbstractMapper<Tag,TagDTO> implements TagMapper {

	@Override
	public Class<? extends TagDTO> dtoClazz() {
		return TagDTO.class;
	}

	@Override
	public Class<? extends Tag> modelClazz() {
		return Tag.class;
	}

}
