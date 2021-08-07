package br.com.fiap.fds.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Parametros;

public class TesteUsuario {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite a palavra: ");
		String palavra = leitor.next() + leitor.nextLine();
				
		System.out.print("Digite a dica: ");
		String dica = leitor.next() + leitor.nextLine();
	
		System.out.print("Digite o numero de vidas: ");										
		int vidas = leitor.nextInt();
		int erros = 0;
	
		int comprimento = palavra.length();
		
		Parametros dados1 = new Parametros(palavra, dica, vidas);
		
		
		String palavra2 = dados1.mudancaAsterisco();
		JOptionPane.showMessageDialog(null, "A Palavra com ast é: \n" + dados1.getPalavraAst());
		JOptionPane.showMessageDialog(null, "A Palavra Original é : \n" + dados1.getPalavra());


					
		String chute = JOptionPane.showInputDialog("Chute: ");	
		
					
		char c = chute.charAt(0);
		
		
		
		
		for(int i = 0; i<palavra.length(); i++) { 
			if (c == palavra.charAt(i)) {
				palavra2 = palavra2.replace(palavra2.charAt(i) , c);
		  
		  }
		  
		  } 
		JOptionPane.showMessageDialog(null, "A Palavra é: \n" + palavra2); 
		chute = JOptionPane.showInputDialog("Chute: ");
		 
			
			
		}
			

		
		
		
			
			
		}
		
		
		
		
		


		
		
		
		
	



