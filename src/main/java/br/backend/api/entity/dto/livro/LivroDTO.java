package br.backend.api.entity.dto.livro;

public class LivroDTO {

	private Long id;
	private String titulo;
	private String autor;
	private String ano;
	private String categoria;
	private String editora;
	private String foto;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	@Override
	public String toString() {
		return "LivroDTO [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano
				+ ", categoria=" + categoria + ", editora=" + editora + ", foto=" + foto + "]";
	}
	
	
	
}
