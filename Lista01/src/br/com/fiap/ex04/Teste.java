package br.com.fiap.ex04;

public class Teste {
	public static void main(String[] args) {
		
		ContaCorrente dados = new ContaCorrente();
		
		dados.saldo = 1000;
		
		dados.depositar(100);
		dados.sacar(200);
		
		System.out.println(dados.saldo);
		
		
		
	}
	
	
}
