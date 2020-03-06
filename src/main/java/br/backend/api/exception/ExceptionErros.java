package br.backend.api.exception;

public class ExceptionErros extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionErros(String mensagem) {
		super(mensagem);
	}
}
