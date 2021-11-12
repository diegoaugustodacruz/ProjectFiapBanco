package br.com.fiap.tds.view.supermercado;

import java.util.Scanner;

import br.com.fiap.tds.bo.SupermercadoBO;
import br.com.fiap.tds.to.SupermercadoTO;

public class SupermercadoCadastrar {

	public static void main(String[] args) {
		
		
		//Instanciar um Alimento
		SupermercadoTO supermercado = new SupermercadoTO();
		
		//Ler os dados
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o nome");
		supermercado.setNome(leitor.next() + leitor.nextLine());
		
		System.out.println("Digite o CNPJ: ");
		supermercado.setCnpj(leitor.next() + leitor.nextLine());
		
		System.out.println("Digite o email: ");
		supermercado.setEmail(leitor.next() + leitor.nextLine());
		
		System.out.println("Digite a senha: ");
		supermercado.setSenha(leitor.next() + leitor.nextLine());				
		
		try {
		
			
			
			SupermercadoBO bo = new SupermercadoBO();
			
			bo.cadastrar(supermercado);
			
			System.out.println("Supermercado registrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main
	
}
