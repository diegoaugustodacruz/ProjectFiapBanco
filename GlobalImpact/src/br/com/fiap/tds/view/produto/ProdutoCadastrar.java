package br.com.fiap.tds.view.produto;

import java.util.Scanner;

import br.com.fiap.tds.bo.ProdutoBO;
import br.com.fiap.tds.to.ProdutoTO;

public class ProdutoCadastrar {
	
	//Cadastro de produto
	public static void main(String[] args) {
		
		
		//Instanciar um Alimento
		ProdutoTO produto = new ProdutoTO();
		
		//Ler os dados
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o nome");
		produto.setNome(leitor.next() + leitor.nextLine());
		
		System.out.println("Digite a quantidade: ");
		produto.setQuantidade(leitor.nextInt());
		
		System.out.println("Digite a data de validade");
		produto.setDataValidade(leitor.next() + leitor.nextLine());
		
		System.out.println("Digite o valor unitario: ");
		produto.setValorUnitario(leitor.nextDouble());
		
		System.out.println("Digite o valor total: ");
		produto.setValorTotal(leitor.nextDouble());		
		
					
		
		try {
		
			
			
			ProdutoBO bo = new ProdutoBO();
			
			bo.cadastrar(produto);
			
			System.out.println("produto registrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main

}
