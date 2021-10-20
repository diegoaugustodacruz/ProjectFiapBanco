package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyUsuario;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basicas com o hobby/usuario no banco
 * @author Endorfina
 *
 */
public class HobbyUsuarioDAO {

	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public HobbyUsuarioDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	/**
	 * Cadastra um hobby/usuario no banco de dados
	 * @param hobbyUsuario HobbyUsuario com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrar(HobbyUsuario hobbyUsuario) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_HOBBY_USUARIO "
				+ "(ID_HOBBY, ID_USUARIO)"
				+ " VALUES (?, ?)");
		
		stmt.setInt(1, hobbyUsuario.getHobby().getIdHobby());
		stmt.setInt(2, hobbyUsuario.getUsuario().getIdUsuario());
		
		stmt.executeUpdate();
	}
	
	/**
	 * Remove um hobbyUsuario no banco de dados
	 * @param codigo PK do usuario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigoUsuario) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_HOBBY_USUARIO WHERE ID_USUARIO = ?");

		stmt.setInt(1, codigoUsuario);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Hobby/Usuario não encontrado para ser removido");
		}
	}	
		
}
