package br.backend.api.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.backend.api.entity.User;
import br.backend.api.exception.ExceptionErros;
import br.backend.api.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>listar(){
		List<User> users = service.listar();		
		return ResponseEntity.ok().body(users);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<User> salvar(@Valid @RequestBody User user) throws ExceptionErros {
		user = service.salvar(user);
		return ResponseEntity.ok().body(user);
		
	}
	
	
}
