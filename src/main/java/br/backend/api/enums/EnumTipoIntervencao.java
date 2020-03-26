package br.backend.api.enums;

public enum EnumTipoIntervencao {
	
	SISTEMA(1),
	SERVICO(2),
	BATCH(3);
	
	private Integer valor;

	private EnumTipoIntervencao(Integer valor) {
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}

}
