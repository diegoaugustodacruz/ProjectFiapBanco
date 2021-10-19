package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.bo.ProdutoBo;
import br.com.fiap.tds.factory.ConnectionFactory;

public class ProdutoPesquisarPorNome {

	// Pesquisar por nome
	public static void main(String[] args) {

		Connection conexao = null;

		try {
			// Obter a conexão
			conexao = ConnectionFactory.getConnection();
			// Instanciar o Bo
			ProdutoBo bo = new ProdutoBo(conexao);
			// Ler o nome
			String nome = JOptionPane.showInputDialog("Digite o nome");
			// Pesquisar por nome
			List<Produto> lista = bo.buscarPorNome(nome);
			// Exibir o resultado
			for (Produto produto : lista) {
				System.out.println(produto);
			}
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
	}// main
}// class