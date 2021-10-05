package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Hobby;


public class HobbyDAO {
	
	private Connection conexao;

	public HobbyDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrarUsuario(Hobby hobby) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_HOBBY "
				+ "(ID_HOBBY, NM_HOBBY)"
				+ " VALUES (SQ_ENDORF_HOBBY.NEXTVAL, ?)");
		
		//passar os valores para o comando SQL
		stmt.setString(1, hobby.getNomeHobby());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	
		//Lista e remover
	
		public void atualizar(Hobby hobby) {
			
		}
		
		public Hobby pesquisar(int codigo) {
			return null;
		}
}
