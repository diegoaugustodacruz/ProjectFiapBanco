package br.com.fiap.tds.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo01 {
	
	public static void main(String[] args) {
			
		Scanner leitor = null;		
		
		try {
			leitor = new Scanner(System.in);
			//Ler um numero
			System.out.println("Digite um numero: ");			
			
			//Codigo que pode lancar uma exception
			int n1 = leitor.nextInt();
			
			//Ler outro numero
			System.out.println("Digite outro numero: ");	
			int n2 = leitor.nextInt();
				
			//Divisao de n1 por n2 e exibir o resultado					
			
			System.out.println("Resultado é: " + n1/n2);
			
			//NumberFormatException (JOptionPane)			
		}catch(InputMismatchException | NumberFormatException e ) {// "e" é o parametro que recebe a exception lançada
			//Tratamento da exception de numero invalido
			System.out.println("Numero informado invalido: " + e.getMessage());
			
		}catch(ArithmeticException e ) {// "e" é o parametro que recebe a exception lançada
			//Tratamento da exception de divisao por zero
			System.out.println("Deu erro: " + e.getMessage());
		}catch(Exception e) {
			System.out.println("Erro!!");
			
		}finally {
			//bloco que sempre será executado, dando ou nao a exception
			//Geralmente utilizado para fechar os recursos abertos
			System.out.println("Sempre será executado!");
			leitor.close();
		}
				
		System.out.println("Finalizando o sistema: ");
								
	}	
}
