package br.backend.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.backend.api.entity.Livro;
import br.backend.api.entity.User;
import br.backend.api.repository.LivroRepository;
import br.backend.api.repository.UserRepository;
import br.backend.api.service.UserService;

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
		Livro livro = new Livro("Java Fundamentos", "Desconhecido","2018", "Tecnologia da Informação", "Digital");
		Livro livro1 = new Livro("Java 8", "Desconhecido","2020", "Tecnologia da Informação", "Digital");
		Livro livro2 = new Livro("Java", "Desconhecido","2019", "Tecnologia da Informação", "Digital");
		Livro livro3 = new Livro("PHP", "Desconhecido","2020", "Tecnologia da Informação", "Digital");
		Livro livro4 = new Livro("Angular", "Desconhecido","2018", "Tecnologia da Informação", "Digital");
		Livro livro5 = new Livro("React", "Desconhecido","2020", "Tecnologia da Informação", "Digital");
		Livro livro6 = new Livro("Redes Basico", "Desconhecido","2020", "Redes", "Digital");
		Livro livro7 = new Livro("Internet", "Desconhecido","2019", "Redes", "Digital");
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
		livro5.setUser(bia);
		livro6.setUser(jose);
		livro7.setUser(maria);
		
		List<Livro> livros = new ArrayList<>();
		livros.addAll(Arrays.asList(livro,livro1,livro2,livro3,livro4,livro5,livro6,livro7));
		
		livros.stream().forEach((l)->livroRepo.save(l));
		
	}
	
	@Test
	public void buscarLivro() {
		List<Livro> livros = livroRepo.findByTitulo("java");
		livros.stream().forEach((l)->System.out.println("Livro: "+l.getTitulo()+"\nUsuario: "+l.getUser().getNome()));
	}

}
