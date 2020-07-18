package br.backend.api.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import br.backend.api.enums.PerfilEnum;
import br.backend.api.livro.LivroDTO;
import br.backend.api.user.telefone.TelefoneDTO;

public class UserDTO {

	
	private Long id;
	@NotBlank(message= "{nome.not.blank}")
	private String nome;
	@NotBlank(message= "{email.not.blank}")
	private String email;
	private String senha;
	private List<LivroDTO> livro = new ArrayList<>();
	private String ip;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
	
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", livro=" + livro
				+ ", ip=" + ip + ", telefones=" + telefones + ", perfil=" + perfil + "]";
	}
	
	
	
	
	
		
	
	
}
