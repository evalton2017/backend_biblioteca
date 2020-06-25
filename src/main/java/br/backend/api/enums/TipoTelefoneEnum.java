package br.backend.api.enums;

public enum TipoTelefoneEnum {
	COMERCIAL("Comercial"),
	CELULAR("Celular");
	
	private String valor;

	private TipoTelefoneEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
