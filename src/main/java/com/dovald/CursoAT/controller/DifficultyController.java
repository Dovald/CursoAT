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

import com.dovald.CursoAT.component.mapper.difficulty.DifficultyMapper;
import com.dovald.CursoAT.dto.DifficultyDTO;
import com.dovald.CursoAT.exception.DuplicatedKeyException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Difficulty;
import com.dovald.CursoAT.service.DifficultyService;

@RestController
@RequestMapping(value = "/difficulty")
public class DifficultyController {
	
	@Autowired
	DifficultyService difficultyService;
	
	@Autowired
	DifficultyMapper difficultyMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<DifficultyDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Difficulty> difficulties = difficultyService.findAll(PageRequest.of(page, size));
		return difficultyMapper.modelToDto(difficulties);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public DifficultyDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Difficulty> difficulty = difficultyService.findById(id);
		if(!difficulty.isPresent()) throw new NotFoundException();
		return difficultyMapper.modelToDto(difficulty.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public DifficultyDTO create(@RequestBody DifficultyDTO dto) throws DuplicatedKeyException {
		final Difficulty difficulty = difficultyMapper.dtoToModel(dto);
		final Optional<Difficulty> difficulty1 = difficultyService.findOneByName(difficulty.getName());
		if(difficulty1.isPresent()) throw new DuplicatedKeyException();
		final Difficulty createDifficulty = difficultyService.create(difficulty);
		return difficultyMapper.modelToDto(createDifficulty);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody DifficultyDTO dto) throws NotFoundException, DuplicatedKeyException {
		final Optional<Difficulty> difficulty = difficultyService.findById(id);
		if(!difficulty.isPresent()) throw new NotFoundException();
		final Difficulty difficulty1 = difficultyMapper.dtoToModel(dto);
		if(difficulty1.getName() == difficulty.get().getName()) throw new DuplicatedKeyException();
		difficulty.get().setName(difficulty1.getName());
		difficultyService.update(difficulty.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Difficulty> difficulty = difficultyService.findById(id);
		if(!difficulty.isPresent()) throw new NotFoundException();
		difficultyService.delete(difficulty.get());
	}

}
