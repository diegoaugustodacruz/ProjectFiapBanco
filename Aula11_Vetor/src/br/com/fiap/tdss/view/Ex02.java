package br.com.fiap.tdss.view;

import javax.swing.JOptionPane;


public class Ex02 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de numeros: "));
		

		int[] numeros = new int[n];
		
		
		for(int i = 0; i<numeros.length; i++) {
			int add = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero: "));			
			numeros[i] = add;			
			
		}
		
		int maior = numeros[0], menor = numeros[0];
		
		for(int churros : numeros) {
						
			if(churros > maior) {
				maior = churros;
				
			}
			else if(churros<menor) {
				menor = churros;
				
			}
			System.out.println(churros);
			
		}
		
		System.out.println("O maior numero eh: " + maior + ". O menor numero eh: " + menor);
		
		
		
		
	}

}