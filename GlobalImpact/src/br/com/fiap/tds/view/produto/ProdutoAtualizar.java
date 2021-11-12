package br.com.fiap.tds.view.produto;

import java.util.Scanner;

import br.com.fiap.tds.bo.ProdutoBO;
import br.com.fiap.tds.to.ProdutoTO;

public class ProdutoAtualizar {
	
public static void main(String[] args) {		
		
		ProdutoTO produto = new ProdutoTO();
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o codigo");
		produto.setIdProduto(leitor.nextInt());
		
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
//		UPDATE T_PRODUTO SET NM_SUPERMERCADO = ?, QT_ESTOQUE = ?,"
//				+ " DT_VALIDADE = ?, VL_UNITARIO = ?, VL_TOTAL = ? WHERE ID_USUARIO = ?
					
		
		try {
		
			
			
			ProdutoBO bo = new ProdutoBO();
			
			bo.atualizar(produto);
			
			System.out.println("produto registrado!");
			
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}//main

}
