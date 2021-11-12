package br.com.fiap.tds.view.endereco;

import java.util.Scanner;

import br.com.fiap.tds.bo.EnderecoBO;
import br.com.fiap.tds.to.EnderecoTO;
import br.com.fiap.tds.to.SupermercadoTO;

public class EnderecoAtualizar {

	public static void main(String[] args) {		
		
		try {		
			
			Scanner leitor = new Scanner(System.in);			
			
			System.out.println("Digite o codigo: ");
			int codigo = (leitor.nextInt());
			
			System.out.println("Digite o cep: ");
			String cep = leitor.next() + leitor.nextLine();
			
			System.out.println("Digite o nome da rua: ");
			String nomeRua = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o numero da rua: ");
			int numeroCasa = (leitor.nextInt());
			
			System.out.println("Digite o nome do bairro: ");
			String bairro = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o nome da cidade: ");
			String cidade = (leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o nome do estado: ");
			String estado = leitor.next() + leitor.nextLine();
			
			EnderecoTO endereco = new EnderecoTO(codigo, numeroCasa, nomeRua, bairro, cidade, estado, cep);
			//int idEndereco, int numeroCasa, String nomeRua, String bairro, String cidade, String estado, String numeroCEP
			
			EnderecoBO bo = new EnderecoBO();
			
			bo.atualizar(endereco);
			
			System.out.println("endereco atualizado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		
		
	}//main
}
