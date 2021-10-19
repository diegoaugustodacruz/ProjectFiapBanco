package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyUsuario;

public class HobbyUsuarioDAO {

	private Connection conexao;

	public HobbyUsuarioDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrarUsuario(HobbyUsuario hobbyUsuario) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_HOBBY_USUARIO "
				+ "(ID_HOBBY, ID_PROFISSIONAL)"
				+ " VALUES (?, ?)");
		
		//passar os valores para o comando SQL
//		stmt.setInt(1, hobbyUsuario.getIdHobby());
//		stmt.setInt(2, hobbyUsuario.getIdUsuario());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	
		//Lista e remover
	
		public void atualizar(HobbyUsuario hobbyUsuario) {
			
		}
		
		public HobbyUsuario pesquisar(int codigo) {
			return null;
		}
}
