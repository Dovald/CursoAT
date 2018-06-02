package com.dovald.CursoAT.component.mapper.tag;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dovald.CursoAT.dto.TagDTO;
import com.dovald.CursoAT.model.Tag;

@Component
public class TagMapperImpl  implements TagMapper {

	@Override
	public Tag dtoToModel(TagDTO dto) {
		Tag model = new Tag();
		model.setId(dto.getId());
		model.setName(dto.getName());
		return model;
	}

	@Override
	public TagDTO modelToDto(Tag model) {
		TagDTO dto = new TagDTO();
		dto.setName(model.getName());
		dto.setId(model.getId());
		return dto;
	}

	@Override
	public List<Tag> dtoToModel(List<TagDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<TagDTO> modelToDto(List<Tag> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}

}
