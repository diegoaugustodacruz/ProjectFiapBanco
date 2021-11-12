package br.com.fiap.tds.view.endereco;

import java.util.Scanner;

import br.com.fiap.tds.bo.EnderecoBO;

public class EnderecoRemover {

	public static void main(String[] args) {		
		
		
		try {			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o codigo");
			int codigo = leitor.nextInt();					
			
			EnderecoBO bo = new EnderecoBO();
			
			bo.remover(codigo);
			
			System.out.println("Endereco removido!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main
}
