package br.com.fiap.tds.view.supermercado;

import java.util.Scanner;

import br.com.fiap.tds.bo.SupermercadoBO;
import br.com.fiap.tds.to.SupermercadoTO;

public class SupermercadoAtualizar {
	public static void main(String[] args) {
		
		
		SupermercadoTO supermercado = new SupermercadoTO();
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o codigo");
		supermercado.setCodigo(leitor.nextInt());
		
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
			
			bo.atualizar(supermercado);
			
			System.out.println("Supermercado registrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main
}
