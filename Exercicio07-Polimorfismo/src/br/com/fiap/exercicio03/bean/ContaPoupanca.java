package br.com.fiap.exercicio03.bean;

public class ContaPoupanca extends ContaBancaria {
	
	private double taxaJuros;
	
	public ContaPoupanca() {
		
	}

	public ContaPoupanca(double saldo, Titular titular, int agencia, String numeroConta, double taxaJuros) {
		super(saldo, titular, agencia, numeroConta);
		this.taxaJuros = taxaJuros;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	public void atualizarSaldo() {
		saldo = saldo + (saldo*(taxaJuros/100));
	}
	
	public String toString() {
		return super.toString() + "\nTaxa de Juros: " + taxaJuros;
	}

}
