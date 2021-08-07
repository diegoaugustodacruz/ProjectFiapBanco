package br.com.fiap.exercicio03.bean;

public class ContaBancaria {
	
	protected double saldo;
	private Titular titular;
	private int agencia;
	private String numeroConta;
	
	public ContaBancaria() {
		
	}

	public ContaBancaria(double conta, Titular titular, int agencia, String numeroConta) {
		super();
		this.saldo = conta;
		this.titular = titular;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double conta) {
		this.saldo = conta;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void sacar(double valor) {
		saldo = saldo - valor;

	}
	
	public void depositar(double valor) {
		saldo = saldo + valor;
		
	}
	
	public String toString() {
		return "SALDO: " + saldo + "\nTitular: " + titular + "\nAgencia: " + "\nNumero da conta: " + numeroConta;
	}
	
	
}
