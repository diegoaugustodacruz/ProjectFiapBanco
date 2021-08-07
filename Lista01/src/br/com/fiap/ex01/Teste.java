package br.com.fiap.ex01;

import java.util.Scanner;

public class Teste {
	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Calculadora dados  = new Calculadora();
		
		System.out.print("Digite um número: ");
		double xe = leitor.nextDouble();
		dados.x = xe;
		
		
		System.out.print("Digite outro número: ");
		double ye = leitor.nextDouble();
		dados.y = ye;

		double soma = dados.somar();
		
		System.out.println("A soma de " + xe + " com " + ye + " é igual à " + soma);
		
		double sub = dados.subtrair();
		
		System.out.println("A subtração de " + xe + " com " + ye + " é igual à " + sub);
		
	}

}
