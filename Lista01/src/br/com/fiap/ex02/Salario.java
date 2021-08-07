package br.com.fiap.ex02;

public class Salario {

	double valorBruto;
	double descontoINSS;
	double salarioLiquido;
		
	void atribuirValorBruto(float valor) {
		valorBruto = valor;
	}
	
	double obterValorBruto() {
		return valorBruto;
		
	}
	
	double calcularINSS() {
		descontoINSS = valorBruto*20/100;
		return descontoINSS;
		
	}
	
	double obterValorLiquido() {
		salarioLiquido = valorBruto - descontoINSS;
		return salarioLiquido;
		
	}
}
