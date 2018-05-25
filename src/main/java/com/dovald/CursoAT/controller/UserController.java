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

import com.dovald.CursoAT.component.mapper.user.UserMapper;
import com.dovald.CursoAT.dto.UserDTO;
import com.dovald.CursoAT.dto.UserPostDTO;
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
	public Set<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public UserDTO findById(@PathVariable Integer id) throws NotFoundException{
		final Optional<User> user = userService.findById(id);
		if(!user.isPresent()) throw new NotFoundException();
		return userMapper.modelToDto(user.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserPostDTO dto) {
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userMapper.modelToDto(createUser);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody UserDTO dto) throws NotFoundException {
		final Optional<User> user = userService.findById(id);
		if(!user.isPresent()) throw new NotFoundException();
		final User user1 = userMapper.dtoToModel(dto);
		user.get().setName(user1.getName());
		user.get().setEmail(user1.getEmail());
		user.get().setPassword(user1.getPassword());
		userService.update(user.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<User> user = userService.findById(id);
		if(!user.isPresent()) throw new NotFoundException();
		userService.delete(user.get());
	}
	
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	@ExceptionHandler({NotFoundException.class})
//	public ErrorDTO notfound() {
//		return new ErrorDTO(NotFoundException.MSG);		
//	}	
//	log.debug("Para el desarrollador");
//	log.info("Informacion necesaria");
//	log.warn("Algo que puede provocar un error");
//	log.error("Excepciones controladas");
//  @Slf4j

}
