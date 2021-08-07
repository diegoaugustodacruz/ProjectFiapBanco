package br.com.fiap.ex04;

public class ContaCorrente {

	double saldo;
	
	void atribuirSaldo(double saldo) {
		this.saldo = saldo;
		
	}
	
	double sacar(double valor) {
		double saldoRestante = saldo - valor;
		saldo = saldoRestante;
		return saldo;
				
	}
	
	double depositar(double valor) {
		double saldoAtual = saldo + valor;
		saldo = saldoAtual;
		return saldo;
		
	}
	
	
}
