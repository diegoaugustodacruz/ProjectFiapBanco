package br.com.fiap.tds.view.produto;

import java.util.Scanner;

import br.com.fiap.tds.bo.ProdutoBO;

public class ProdutoRemover {

	public static void main(String[] args) {		
		
		
		try {			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o codigo");
			int codigo = leitor.nextInt();					
			
			ProdutoBO bo = new ProdutoBO();
			
			bo.remover(codigo);
			
			System.out.println("Produto removido!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main
	
}
