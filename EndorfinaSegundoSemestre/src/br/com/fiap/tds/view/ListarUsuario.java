package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bo.UsuarioBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class ListarUsuario {

public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			//Obter uma conex�o
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar o Dao
			UsuarioBO bo = new UsuarioBO(conexao);
			
			//Pesquisar todos os produtos
			List<Usuario> lista = bo.listar();
			
			//Exibir os produtos
			for (Usuario usuario : lista) {
				System.out.println(usuario);
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
}
