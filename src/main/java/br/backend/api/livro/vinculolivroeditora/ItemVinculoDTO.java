package br.backend.api.livro.vinculolivroeditora;

import java.util.ArrayList;
import java.util.List;

import br.backend.api.livro.Livro;
import br.backend.api.livro.editora.Editora;

public class ItemVinculoDTO {

	private Long id;
	private Editora editora;
	private List<Livro> livros = new ArrayList<Livro>();
	private Long posicao;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public Long getPosicao() {
		return posicao;
	}
	public void setPosicao(Long posicao) {
		this.posicao = posicao;
	} 
	
	
	
	
}
