package br.com.fiap.tds.view.doacaovenda;

import java.util.Scanner;

import br.com.fiap.tds.bo.DoacaoVendaBO;
import br.com.fiap.tds.to.DoacaoVendaTO;
import br.com.fiap.tds.to.ProdutoTO;
import br.com.fiap.tds.to.SupermercadoTO;

public class DoacaoVendaCadastrar {
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
		
		
		//Instanciar um Alimento
			ProdutoTO produto = new ProdutoTO();
			
			
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
			
			DoacaoVendaTO dv = new DoacaoVendaTO(supermercado, produto);
		
		try {
		
			
			
			DoacaoVendaBO bo = new DoacaoVendaBO();
			
			bo.cadastrar(dv);
			
			System.out.println("dv registrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main
}
