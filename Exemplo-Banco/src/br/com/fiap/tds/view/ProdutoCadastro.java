package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.tds.bean.Categoria;
import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.bo.ProdutoBo;
import br.com.fiap.tds.factory.ConnectionFactory;

public class ProdutoCadastro {

	//Cadastro de produto
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
		
			//Instanciar um Produto
			Produto produto = new Produto();
			
			//Ler os dados
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Digite o nome");
			produto.setNome(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite a descrição");
			produto.setDescricao(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o valor");
			produto.setValor(leitor.nextDouble());
			
			System.out.println("Digite o fornecedor");
			produto.setNomeFornecedor(leitor.next() + leitor.nextLine());
			
			System.out.println("Digite o código da categoria");
			Categoria categoria = new Categoria();
			categoria.setCodigo(leitor.nextInt());
			
			produto.setCategoria(categoria);
			
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar um Dao
			//ProdutoDao dao = new ProdutoDao(conexao);
			ProdutoBo bo = new ProdutoBo(conexao);
			
			//Cadastrar um produto chamando o Dao
			bo.cadastrar(produto);
			
			System.out.println("Produto registrado!");
			
			//Fechar
			leitor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conexao != null)
					conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//main
}//class