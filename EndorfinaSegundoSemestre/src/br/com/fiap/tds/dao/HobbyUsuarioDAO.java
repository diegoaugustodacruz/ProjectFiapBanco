package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyUsuario;
import br.com.fiap.tds.exception.IdNotFoundException;

public class HobbyUsuarioDAO {

	private Connection conexao;

	public HobbyUsuarioDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrar(HobbyUsuario hobbyUsuario) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_HOBBY_USUARIO "
				+ "(ID_HOBBY, ID_USUARIO)"
				+ " VALUES (?, ?)");
		
		stmt.setInt(1, hobbyUsuario.getHobby().getIdHobby());
		stmt.setInt(2, hobbyUsuario.getUsuario().getIdUsuario());
		
		stmt.executeUpdate();
	}
	
	
	public void remover(int codigoUsuario) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_HOBBY_USUARIO WHERE ID_USUARIO = ?");

		stmt.setInt(1, codigoUsuario);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Hobby/Usuario não encontrado para ser removido");
		}
	}	
		
}
