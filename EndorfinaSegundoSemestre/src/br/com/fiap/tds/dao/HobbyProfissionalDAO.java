package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyProfissional;

public class HobbyProfissionalDAO {

	private Connection conexao;

	public HobbyProfissionalDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrarUsuario(HobbyProfissional hobbyProfissional) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_HOBBY_PROFISSIONAL "
				+ "(ID_HOBBY, ID_PROFISSIONAL)"
				+ " VALUES (?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setInt(1, hobbyProfissional.getIdHobby());
		stmt.setInt(2, hobbyProfissional.getIdProfissional());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	
		//Lista e remover
	
		public void atualizar(HobbyProfissional hobbyProfissional) {
			
		}
		
		public HobbyProfissional pesquisar(int codigo) {
			return null;
		}
}
