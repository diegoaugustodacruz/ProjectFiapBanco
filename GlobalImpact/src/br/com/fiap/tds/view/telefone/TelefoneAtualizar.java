package br.com.fiap.tds.view.telefone;

import java.util.Scanner;

import br.com.fiap.tds.bo.TelefoneBO;
import br.com.fiap.tds.to.TelefoneTO;

public class TelefoneAtualizar {

	public static void main(String[] args) {		
		
		try {		
			
			Scanner leitor = new Scanner(System.in);
			
			
			System.out.println("Digite o codigo: ");
			int codigo = leitor.nextInt();
						
			System.out.println("Digite o ddi: ");
			String ddi = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o ddd: ");
			int ddd = (leitor.nextInt());
			
			System.out.println("Digite o tel: ");
			int tel = (leitor.nextInt());
			
			
			TelefoneTO telefone = new TelefoneTO(ddi, ddd, tel, codigo);	
			//int ddi, int ddd, int numeroTel, int idTelefone
			TelefoneBO bo = new TelefoneBO();
			
			bo.atualizar(telefone);
			
			System.out.println("Telefone cadastrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		
		
	}//main	

}
