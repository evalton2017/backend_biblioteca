package br.backend.api.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api.exception.ExceptionErros;
import br.backend.api.user.telefone.TelefoneMapper;
import br.backend.api.user.telefone.TelefoneService;
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
		return  userMapper.toDtoList(usuarios);
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
	
	public  UserDTO atualizar(UserUpdateDTO dto, Long id) throws ExceptionErros {
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
		user.getTelefones().forEach(t -> {
			t.setUser(user);
		});
		
		if(!user.getLivros().isEmpty()) {
			user.getLivros().forEach( l -> {
				l.setUser(user);
			});
		}
		
		
		
	}
	
	
	
}
