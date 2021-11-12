package br.com.fiap.tds.view.supermercado;

import java.util.Scanner;

import br.com.fiap.tds.bo.SupermercadoBO;
import br.com.fiap.tds.to.SupermercadoTO;

public class SupermercadoRemover {

public static void main(String[] args) {		
		
		
		try {			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o codigo");
			int codigo = leitor.nextInt();					
			
			SupermercadoBO bo = new SupermercadoBO();
			
			bo.remover(codigo);
			
			System.out.println("Supermercado removido!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main
}
