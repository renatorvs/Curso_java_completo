package br.com.bitebank.banco.modelo;



public class SaldoInsuficienteException extends Exception {
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
}
