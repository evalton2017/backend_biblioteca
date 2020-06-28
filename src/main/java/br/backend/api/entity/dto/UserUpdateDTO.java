package br.backend.api.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import br.backend.api.entity.dto.livro.LivroDTO;
import br.backend.api.entity.dto.telefone.TelefoneDTO;
import br.backend.api.enums.PerfilEnum;

public class UserUpdateDTO {

	
	private Long id;
	@NotBlank(message= "{nome.not.blank}")
	private String nome;
	@NotBlank(message= "{email.not.blank}")
	private String email;
	private List<LivroDTO> livro = new ArrayList<>();
	private List<TelefoneDTO> telefones = new ArrayList<>();;
	private PerfilEnum perfil;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<LivroDTO> getLivro() {
		return livro;
	}
	public void setLivro(List<LivroDTO> livro) {
		this.livro = livro;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}
	
	
	
	
	
	
	
		
	
	
}
