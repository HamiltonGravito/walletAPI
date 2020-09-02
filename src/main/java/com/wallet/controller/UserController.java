package com.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserDTO;
import com.wallet.entity.User;
import com.wallet.response.Response;
import com.wallet.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Validated @RequestBody UserDTO dto, BindingResult result){
		
		Response<UserDTO> response = new Response<UserDTO>();
		
		User user = service.save(convertDtoEntity(dto));
		
		response.setData(this.convertEntityDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	public User convertDtoEntity(UserDTO dto) {
		User u = new User();
		u.setName(dto.getName());
		u.setPassword(dto.getPassword());
		u.setEmail(dto.getEmail());
		return u;
	}
	
	public UserDTO convertEntityDto(User u) {
		UserDTO dto = new UserDTO();
		dto.setName(u.getName());
		dto.setPassword(u.getPassword());
		dto.setEmail(u.getEmail());
		return dto;
	}
}
