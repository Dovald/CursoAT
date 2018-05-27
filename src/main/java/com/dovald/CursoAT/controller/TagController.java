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

import com.dovald.CursoAT.component.mapper.tag.TagMapper;
import com.dovald.CursoAT.dto.TagDTO;
import com.dovald.CursoAT.exception.DuplicatedKeyException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Tag;
import com.dovald.CursoAT.service.TagService;

@RestController
@RequestMapping(value = "/tag")
public class TagController {
	
	@Autowired
	TagService tagService;
	
	@Autowired
	TagMapper tagMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<TagDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Tag> tags = tagService.findAll(PageRequest.of(page, size));
		return tagMapper.modelToDto(tags);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public TagDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Tag> tag = tagService.findById(id);
		if(!tag.isPresent()) throw new NotFoundException();
		return tagMapper.modelToDto(tag.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public TagDTO create(@RequestBody TagDTO dto) throws DuplicatedKeyException {
		final Tag tag = tagMapper.dtoToModel(dto);
		final Optional<Tag> tag1 = tagService.findOneByName(tag.getName());
		if(tag1.isPresent()) throw new DuplicatedKeyException();
		final Tag createTag = tagService.create(tag);
		return tagMapper.modelToDto(createTag);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody TagDTO dto) throws NotFoundException, DuplicatedKeyException {
		final Optional<Tag> tag = tagService.findById(id);
		if(!tag.isPresent()) throw new NotFoundException();
		final Tag tag1 = tagMapper.dtoToModel(dto);
		if(tag1.getName() == tag.get().getName()) throw new DuplicatedKeyException();
		tag.get().setName(tag1.getName());
		tagService.update(tag.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Tag> tag = tagService.findById(id);
		if(!tag.isPresent()) throw new NotFoundException();
		tagService.delete(tag.get());
	}

}
