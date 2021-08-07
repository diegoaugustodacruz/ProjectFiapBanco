package br.com.fiap.tds.view;

import java.util.Scanner;

public class TesteOperadores {
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite um número:");
		int x = leitor.nextInt();
				
		System.out.print("Digite outro numero: ");
		int y = leitor.nextInt();
		
		System.out.print(x-y);
		
		leitor.close();
		
	}

}
