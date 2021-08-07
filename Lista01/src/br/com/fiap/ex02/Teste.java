package br.com.fiap.ex02;

public class Teste {

	public static void main(String[] args) {
		
		Salario valores = new Salario();
		
		valores.atribuirValorBruto(5);
		
		double x = valores.calcularINSS();
		double y = valores.obterValorLiquido();
		
		
		
		System.out.println("Salário Bruto é: " + valores.valorBruto);
		
		System.out.println("O desconto do INSS é: " + x);
		
		System.out.println("O salário líquido é: " + y);
		
		
		
		
		
	}
	
}
