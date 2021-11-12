package br.com.fiap.tds.view.endereco;

import java.sql.Connection;
import java.util.Scanner;

import br.com.fiap.tds.bo.EnderecoBO;
import br.com.fiap.tds.singleton.ConnectionManager;
import br.com.fiap.tds.to.EnderecoTO;
import br.com.fiap.tds.to.SupermercadoTO;

public class EnderecoCadastrar {
	
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
			
			EnderecoTO endereco = new EnderecoTO(numeroCasa, nomeRua, bairro, cidade, estado, cep, supermercado);
			
			EnderecoBO bo = new EnderecoBO();
			
			bo.cadastrar(endereco);
			
			System.out.println("endereco registrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		
		
	}//main

}
