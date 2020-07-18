package br.backend.api.livro.editora.contato;

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
import br.backend.api.livro.editora.Editora;


@Entity
@Audited
@Table
@AuditTable(value = "contato_audit")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="numero")
	private String numero;	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo", nullable = false)
	private TipoTelefoneEnum tipo;	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="editora_id")
	private Editora editora;
	
	public Contato() {
		
	}

	public Contato(Long id, String numero, TipoTelefoneEnum tipo, Editora editora) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.editora = editora;
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

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	
	
	
}
