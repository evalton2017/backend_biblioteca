package br.backend.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.backend.api.enums.PerfilEnum;
import br.backend.api.user.User;
import br.backend.api.user.UserRepository;
import br.backend.api.user.telefone.Telefone;
import br.backend.api.utils.SenhaUtil;

@SpringBootTest
public class UserTest {

	@Autowired
	UserRepository userRepo;
	
//	@Ignore
//	void salvar() {
//		Set<Telefone> telefones = new HashSet<>();
//		telefones.add("6198556666");
//		telefones.add("6196563226");
//		telefones.add("6198000230");
//			
//		User user= new User(2L,"Beatriz Gomes", "bia@gmail.com", SenhaUtil.GerarBcript("123456"),PerfilEnum.ROLE_ADMIN,telefones);
//		User user1= new User(3L,"Jose Silva", "jose@gmail.com", SenhaUtil.GerarBcript("123456"),PerfilEnum.ROLE_USUARIO,telefones);
//		User user2= new User(4L,"Maria Gorete", "maria@gmail.com", SenhaUtil.GerarBcript("123456"),PerfilEnum.ROLE_USUARIO,telefones);
//		
//		List<User> usuarios = new ArrayList<User>();
//		usuarios.addAll(Arrays.asList(user,user1,user2));
//		
//		usuarios.stream().forEach((u)->userRepo.save(u));
//		
//	}

	@org.junit.jupiter.api.Test
	void buscar() {
		User user = userRepo.findByEmail("bia@gmail.com");
		System.out.println("Teste pesquisa por email");
		System.out.println("Nome: "+user.getNome());
		//System.out.println(user);
		
	}
	
	@org.junit.jupiter.api.Test
	void listar() {
		List<User> usuarios = userRepo.findAll();
		System.out.println("Teste listar todos");
		usuarios.stream().forEach((u)->System.out.println(u.getNome()));
	}
	
	
}
