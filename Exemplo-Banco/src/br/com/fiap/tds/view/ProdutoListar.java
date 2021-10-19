package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.bo.ProdutoBo;
import br.com.fiap.tds.factory.ConnectionFactory;

public class ProdutoListar {

	//Listar
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			//Obter uma conexão
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar o Dao
			ProdutoBo bo = new ProdutoBo(conexao);
			
			//Pesquisar todos os produtos
			List<Produto> lista = bo.listar();
			
			//Exibir os produtos
			for (Produto produto : lista) {
				System.out.println(produto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conexao != null) conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//main
}//class