package br.backend.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.backend.api.livro.Livro;
import br.backend.api.livro.LivroRepository;
import br.backend.api.user.UserRepository;

@SpringBootTest
class EstudoApiApplicationTests {

	@Autowired
	LivroRepository livroRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	void salvar() {
		Livro livro = new Livro("Desenvolvimento Java", "2020", "Tecnologia da Informação", "Digital");
		livroRepo.save(livro);
		
		
	}
	

}
