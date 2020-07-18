package br.backend.api.user.telefone;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.backend.api.enums.TipoTelefoneEnum;
import br.backend.api.user.User;

@Entity
@Audited
@Table
@AuditTable(value = "telefone_audit")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numero;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", nullable = false)
	private TipoTelefoneEnum tipo;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="user_id")
	private User user;
	
	public Telefone() {
		
	}

	public Telefone(Long id, String numero, TipoTelefoneEnum tipo, User user) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTelefoneEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefoneEnum tipo) {
		this.tipo = tipo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
