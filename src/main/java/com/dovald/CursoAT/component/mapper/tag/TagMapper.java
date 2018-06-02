package com.dovald.CursoAT.component.mapper.tag;

import java.util.List;

import com.dovald.CursoAT.dto.TagDTO;
import com.dovald.CursoAT.model.Tag;

public interface TagMapper {
	
	public Tag dtoToModel(TagDTO dto);
	public TagDTO modelToDto(Tag model);
	public List<Tag> dtoToModel(List<TagDTO> dtos);
	public List<TagDTO> modelToDto(List<Tag> models);
}
