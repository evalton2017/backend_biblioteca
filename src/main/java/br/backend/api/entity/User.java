package br.backend.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.backend.api.enums.PerfilEnum;

@Entity
@Audited
@Table
@AuditTable(value = "user_audit")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max=50)
	@Column(name="nome")
	private String nome;
	@NotNull
	@Column(unique=true)
	private String email;
	@NotNull
	private String senha;
	
	//@ElementCollection
	//@CollectionTable(name="user_telefone", joinColumns = @JoinColumn(name="user_id"))
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	@JsonIgnore
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Livro> livros = new ArrayList<Livro>();
	
	@Enumerated(EnumType.STRING)
	@Column(name="perfil", nullable = false)
	private PerfilEnum perfil;
	
	@Transient
	private String ip;
	
	public User() {
		
	}
	
	public User(Long id, @NotNull @Size(max = 50) String nome, @NotNull String email, @NotNull String senha,PerfilEnum perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil=perfil;
	}
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefones="
				+ telefones + ", livros=" + livros + ", perfil=" + perfil + ", ip=" + ip + "]";
	}


	
	
	
	
	
	
	

}
