package br.backend.api.livro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository repo;
	
	public List<Livro> listar(){
		List<Livro> livros = repo.findAll();
		return livros;
	}
	
	public Livro salvar(Livro livro) {
		
		return  livro = repo.save(livro);
	}
	
	public List<Livro> buscarLivros(String titulo){
		List<Livro> livros = repo.findByTitulo(titulo);
		return livros;
	}
	
	public Livro buscarPorId(Long id) throws Exception {
		Optional<Livro> livro = repo.findById(id);
		return livro.orElseThrow(()-> new Exception(
				"Livro não encontrada Id:"+id+",: "+ Livro.class.getName()));
	}
	
}
