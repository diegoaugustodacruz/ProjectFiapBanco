package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.bo.ProdutoBo;
import br.com.fiap.tds.exception.DadoInvalidoException;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class ProdutoAtualizacao {

	//Exemplo de atualização
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar um ProdutoDao
			//ProdutoDao dao = new ProdutoDao(conexao);
			
			//Ler os dados para atualizar o produto
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Digite o código");
			int codigo = sc.nextInt();
			
			System.out.println("Digite o nome");
			String nome = sc.next() + sc.nextLine();
			
			System.out.println("Digite a descrição");
			String descricao = sc.next() + sc.nextLine();
			
			System.out.println("Digite o valor");
			double valor = sc.nextDouble();
			
			System.out.println("Digite o fornecedor");
			String fornecedor = sc.next() + sc.nextLine();
			
			//Instanciar o produto com os dados
			Produto produto = new Produto(codigo, nome, descricao, valor, fornecedor);
			
			//Atualizar
			ProdutoBo bo = new ProdutoBo(conexao);
			bo.atualizar(produto);
			
			System.out.println("Produto atualizado!");
		
			sc.close();
		} catch (IdNotFoundException | DadoInvalidoException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Fechar
			try {
				if (conexao != null) conexao.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}//main
}//class