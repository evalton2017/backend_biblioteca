package br.backend.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api.entity.Livro;
import br.backend.api.entity.Telefone;
import br.backend.api.entity.User;
import br.backend.api.entity.dto.UserDTO;
import br.backend.api.entity.dto.UserMapper;
import br.backend.api.entity.dto.UserUpdateDTO;
import br.backend.api.entity.dto.telefone.TelefoneMapper;
import br.backend.api.exception.ExceptionErros;
import br.backend.api.repository.TelefoneRepository;
import br.backend.api.repository.UserRepository;
import br.backend.api.utils.SenhaUtil;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	TelefoneMapper telefoneMapper;
	
	@Autowired
	TelefoneService telService;
	
	public UserDTO salvar(User user) throws ExceptionErros {
		user.setSenha(SenhaUtil.GerarBcript(user.getSenha()));
		setFilhos(user);
		repo.save(user);
		return userMapper.toDto(user);
	}
	
	public List<UserDTO> listar(){
		List<User> usuarios = repo.findAll();
		return userMapper.toDtoList(usuarios);
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
	
	public UserDTO atualizar(UserUpdateDTO dto, Long id) throws ExceptionErros {
		User user = buscar(id);		
		userMapper.updateModel(dto, user);
		setFilhos(user);
		repo.save(user);
		UserDTO dtoUser = userMapper.toDto(user);
		return dtoUser;
	}
	
	public User buscar(Long id) throws ExceptionErros{
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(()-> new ExceptionErros(
				"Usuario não encontrada Id:"+id+", tipo: "+ User.class.getName()));
	}
	
	private void setFilhos(User user) throws ExceptionErros {
		List<Telefone> telefones = new ArrayList<>();
		List<Livro> livros = new ArrayList<>();			
		user.getTelefones().forEach(t -> {
//			if(t.getId()!=null) {
//				try {
//					Telefone telefone = telService.buscarPorId(t.getId());
//					telefones.add(telefone);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}			
//			}else {
//				
//			}
			t.setUser(user);
		});
		
		if(!user.getLivros().isEmpty()) {
			user.getLivros().forEach( l -> {
				l.setUser(user);
			});
		}
		
		
		
	}
	
	
	
}
