package br.com.fiap.tds.view.telefone;

import java.util.Scanner;

import br.com.fiap.tds.bo.TelefoneBO;

public class TelefoneRemover {
	public static void main(String[] args) {		
		
		
		try {			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o codigo");
			int codigo = leitor.nextInt();					
			
			TelefoneBO bo = new TelefoneBO();
			
			bo.remover(codigo);
			
			System.out.println("Telefone removido!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main

}
