package br.backend.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.backend.api.livro.Livro;
import br.backend.api.livro.LivroRepository;
import br.backend.api.user.User;
import br.backend.api.user.UserRepository;
import br.backend.api.user.UserService;

@SpringBootTest
public class LivroTest {
	
	@Autowired
	LivroRepository livroRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userService;
	
	
	@Ignore
	void salvar() {
		Livro livro = new Livro("Java Fundamentos", "2018", "Tecnologia da Informação", "Digital");
		Livro livro1 = new Livro("Java 8","2020", "Tecnologia da Informação", "Digital");
		Livro livro2 = new Livro("Java", "2019", "Tecnologia da Informação", "Digital");
		Livro livro3 = new Livro("PHP", "2020", "Tecnologia da Informação", "Digital");
		Livro livro4 = new Livro("Angular", "2018", "Tecnologia da Informação", "Digital");
		User bia = null;
		User jose = null;
		User maria = null;
		try {
			bia = userService.buscarPorId(9L);
			jose = userService.buscarPorId(10L);
			maria = userService.buscarPorId(11L);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		livro.setUser(maria);
		livro1.setUser(bia);
		livro2.setUser(bia);
		livro3.setUser(jose);
		livro4.setUser(maria);
		
		List<Livro> livros = new ArrayList<>();
		livros.addAll(Arrays.asList(livro,livro1,livro2,livro3,livro4));
		
		livros.stream().forEach((l)->livroRepo.save(l));
		
	}
	
	@Test
	public void buscarLivro() {
		List<Livro> livros = livroRepo.findByTitulo("java");
		livros.stream().forEach((l)->System.out.println("Livro: "+l.getTitulo()+"\nUsuario: "+l.getUser().getNome()));
	}

}
