package br.backend.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.backend.api.entity.User;
import br.backend.api.entity.dto.UserDTO;
import br.backend.api.entity.dto.UserUpdateDTO;
import br.backend.api.exception.ExceptionErros;
import br.backend.api.repository.TelefoneRepository;
import br.backend.api.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService service;
	
	TelefoneRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>>listar(){
		List<UserDTO> users = service.listar();	
		return ResponseEntity.ok().body(users);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<UserDTO> salvar(@RequestBody @Valid User user,HttpServletRequest request) throws ExceptionErros {
		user.setIp(request.getRemoteAddr());
		request.getSession().setAttribute("usuarioLogado", user);
		UserDTO use = service.salvar(user);

		return new ResponseEntity<>(use, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<UserDTO> atualizar(@Valid @RequestBody UserUpdateDTO objDTO, @PathVariable Long id) throws ExceptionErros {
		UserDTO use = service.atualizar(objDTO, id);
		return new ResponseEntity<>(use, HttpStatus.OK);
		
	}
	
	
}
