package br.backend.api.entity.dto.telefone;

import br.backend.api.enums.TipoTelefoneEnum;

public class TelefoneDTO {

	private Long id;
	
	private String numero;
	
	private TipoTelefoneEnum tipo;

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


	@Override
	public String toString() {
		return "TelefoneDTO [id=" + id + ", numero=" + numero + ", tipo=" + tipo + "]";
	}
	
	
	
	

}
