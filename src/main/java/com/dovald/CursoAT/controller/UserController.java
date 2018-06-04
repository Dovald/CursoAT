package com.dovald.CursoAT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dovald.CursoAT.component.mapper.user.UserMapper;
import com.dovald.CursoAT.dto.UserDTO;
import com.dovald.CursoAT.exception.DuplicatedKeyException;
import com.dovald.CursoAT.exception.EmptyFieldException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.User;
import com.dovald.CursoAT.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;

	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public UserDTO findById(@PathVariable Integer id) throws NotFoundException{
		final Optional<User> user = userService.findById(id);
		if(!user.isPresent()) throw new NotFoundException();
		return userMapper.modelToDto(user.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserDTO dto) throws EmptyFieldException, DuplicatedKeyException {
		if(dto.getName() == null) throw new EmptyFieldException();
		if(dto.getEmail() == null) throw new EmptyFieldException();
		final Optional<User> user1 = userService.findOneByEmail(dto.getEmail());
		if(user1.isPresent()) throw new DuplicatedKeyException();
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userMapper.modelToDto(createUser);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody UserDTO dto) throws NotFoundException, DuplicatedKeyException {
		final Optional<User> user = userService.findById(id);
		if(!user.isPresent()) throw new NotFoundException();
		final Optional<User> user1 = userService.findOneByEmail(dto.getEmail());
		if(user1.isPresent()) throw new DuplicatedKeyException();		
		final User user2 = userMapper.dtoToModel(dto);
		if (user2.getName() != null) user.get().setName(user2.getName());
		if (user2.getEmail() != null) user.get().setEmail(user2.getEmail());
		userService.update(user.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<User> user = userService.findById(id);
		if(!user.isPresent()) throw new NotFoundException();
		userService.delete(user.get());
	}
}
