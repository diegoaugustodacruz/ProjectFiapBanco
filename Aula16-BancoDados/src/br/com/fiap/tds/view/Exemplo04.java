package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.factory.ConnectionFactory;

public class Exemplo04 {
	
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		
		try {
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();

			//Insntaciar um ProdutoDao
			ProdutoDao dao = new ProdutoDao(conexao);

			//Ler os dados
			Scanner leitor = new Scanner(System.in);

			
			System.out.println("Digite o código: ");
			int codigo = leitor.nextInt();
			
			System.out.println("Digite o nome: ");
			String nome = leitor.next() + leitor.nextLine();
			
			System.out.println("Digite a descricao: ");
			String descricao = leitor.next() + leitor.nextLine();

			
			System.out.println("Digite o valor: ");
			double valor = leitor.nextDouble();
			
			System.out.println("Digite o fornecedor: ");
			String fornecedor = leitor.next() + leitor.nextLine();

			//Instanciar um Produto
			Produto produto = new Produto(codigo, nome, descricao, valor, fornecedor);						
						
			//Atualizar um produto chamando o Dao
			dao.atualizar(produto);
			
			System.out.println("Produto Atualizado");
			
			//Fechar
			leitor.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		
		} finally {
			try {
				if(conexao != null) {
					conexao.close();
					
				}
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}

}
