package br.com.fiap.tds.view.doacaovenda;

import java.util.Scanner;

import br.com.fiap.tds.bo.DoacaoVendaBO;

public class DoacaoVendaRemover {
	public static void main(String[] args) {		
		
		
		try {			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o codigo");
			int codigo = leitor.nextInt();					
			
			DoacaoVendaBO bo = new DoacaoVendaBO();
			
			bo.remover(codigo);
			
			System.out.println("Doacao Venda removido!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main
}

