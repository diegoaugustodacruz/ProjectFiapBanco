package br.com.fiap.tds.bean;

import br.com.fiap.tds.exception.SaldoInsuficienteException;
import br.com.fiap.tds.exception.ValorNegativoException;

public class ContaCorrente {

	private double saldo, limite;
	
	
	public ContaCorrente() {
		
	}

	public ContaCorrente(double saldo, double limite) throws ValorNegativoException{		
		this.saldo = saldo;
		setLimite(limite);
}	
	
	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) throws ValorNegativoException{
		validarValorNegativo(limite);
		this.limite = limite;
	}	
	
	
	public void sacar(double valor)  throws ValorNegativoException, SaldoInsuficienteException{		
		validarValorNegativo(valor);
		
		if(valor>limite) {
			throw new SaldoInsuficienteException("Saldo Insuficiente, valor disponivel: " + (saldo + limite));
		}
		
		saldo = saldo - valor;
		
	}
	
	public void depositar (double valor) throws ValorNegativoException{
		validarValorNegativo(valor);
		saldo = saldo + valor;
	}
	
	public String toString() {
		return "Saldo: " + saldo + "\nLimite: " + limite;
	}
	
	//Criar um método para validar se o valor é negativo
	private void validarValorNegativo(double valor) throws ValorNegativoException{
		if(valor<0) {
			throw new ValorNegativoException();
		}
	}
	
}
