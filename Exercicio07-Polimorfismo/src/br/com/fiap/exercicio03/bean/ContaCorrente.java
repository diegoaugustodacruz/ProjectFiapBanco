package br.com.fiap.exercicio03.bean;

public class ContaCorrente extends ContaBancaria {
	
	private double limiteCredito;
	
	public ContaCorrente() {
		
	}

	public ContaCorrente(double saldo, Titular titular, int agencia, String numeroConta, double limiteCredito) {
		super(saldo, titular, agencia, numeroConta);
		this.limiteCredito = limiteCredito;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String toString() {
		return super.toString() + "\nLimite de credito: " + limiteCredito;
	}
	
	
	

}
