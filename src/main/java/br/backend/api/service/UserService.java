package br.backend.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api.entity.User;
import br.backend.api.exception.ExceptionErros;
import br.backend.api.repository.UserRepository;
import br.backend.api.utils.SenhaUtil;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public User salvar(User user) throws ExceptionErros {
		user.setSenha(SenhaUtil.GerarBcript(user.getSenha()));
		User usuario = repo.save(user);
		return usuario;
	}
	
	public List<User> listar(){
		List<User> usuarios = repo.findAll();
		
		return usuarios;
	}
	
	public User buscarPorEmail(String email) {
		User user = repo.findByEmail(email);
		return user;
	}
	
	public User buscarPorId(Long id) throws Exception {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(()-> new Exception(
				"Usuario não encontrada Id:"+id+",: "+ User.class.getName()));
	}
	
	
	
	
}
