package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.bo.ProdutoBo;
import br.com.fiap.tds.factory.ConnectionFactory;

public class Exemplo09 {
	
	//Ex pesquisar por nome
		public static void main(String[] args) {
			
			Connection conexao = null;
			
			
			try {
				conexao = ConnectionFactory.getConnection();

				ProdutoBo bo = new ProdutoBo(conexao);
				
				
				String nome = JOptionPane.showInputDialog("Digite o nome");
				
				List<Produto> lista = bo.buscarPorNome(nome);
				
				for(Produto produto: lista) {
					System.out.println(produto);
				}
				
				
				
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
