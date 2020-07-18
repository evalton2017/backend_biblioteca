package br.backend.api.livro.vinculolivroeditora;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

import br.backend.api.livro.Livro;
import br.backend.api.livro.editora.Editora;

@Entity
@Audited
public class ItemEditoraLivro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="editora_id")
	private  Editora editora;
	
	@ManyToMany
	@JoinTable(name="vinculo_editora_livro",
			joinColumns = {@JoinColumn(name = "livro_id")},
			inverseJoinColumns = {@JoinColumn(name = "editora_id")})
	private List<Livro> livros = new ArrayList<Livro>(); 
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long posicao;
	
	public ItemEditoraLivro() {
		
	}
	
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
