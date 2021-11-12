package br.com.fiap.tds.view.telefone;

import java.util.Scanner;

import br.com.fiap.tds.bo.TelefoneBO;
import br.com.fiap.tds.to.SupermercadoTO;
import br.com.fiap.tds.to.TelefoneTO;

public class TelefoneCadastrar {
	
	public static void main(String[] args) {		
		
		try {		
			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o nome");
			String nome = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o CNPJ: ");
			String cnpj = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o email: ");
			String email = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a senha: ");
			String senha = (leitor.next() + leitor.nextLine());
			
			SupermercadoTO supermercado = new SupermercadoTO(nome, cnpj, email, senha);
			
			
						
			System.out.println("Digite o ddi: ");
			int ddi = (leitor.nextInt());
			
			System.out.println("Digite o ddd: ");
			int ddd = (leitor.nextInt());
			
			System.out.println("Digite o tel: ");
			int tel = (leitor.nextInt());
			
			
			TelefoneTO endereco = new TelefoneTO(ddi, ddd, tel, supermercado);
			
//			conexao = ConnectionManager.getInstance().getConnection();

			
			TelefoneBO bo = new TelefoneBO();
			
			bo.cadastrar(endereco);
			
			System.out.println("Telefone registrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		
		
	}//main	

}
