package br.backend.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.backend.api.entity.Livro;
import br.backend.api.repository.LivroRepository;
import br.backend.api.repository.UserRepository;

@SpringBootTest
class EstudoApiApplicationTests {

	@Autowired
	LivroRepository livroRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	void salvar() {
		Livro livro = new Livro("Desenvolvimento Java", "Desconhecido","2020", "Tecnologia da Informação", "Digital");
		livroRepo.save(livro);
		
		
	}
	

}
