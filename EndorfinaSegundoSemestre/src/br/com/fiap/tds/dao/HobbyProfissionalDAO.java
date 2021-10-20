package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyProfissional;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basicas com o hobby/profissional no banco
 * @author Endorfina
 *
 */
public class HobbyProfissionalDAO {

	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public HobbyProfissionalDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	/**
	 * Cadastra um hobby/profissional no banco de dados
	 * @param hobbyUsuario HobbyProfissional com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrar(HobbyProfissional hobbyProfissional) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_HOBBY_PROFISSIONAL "
				+ "(ID_HOBBY, ID_PROFISSIONAL)"
				+ " VALUES (?, ?)");
		
		stmt.setInt(1, hobbyProfissional.getHobby().getIdHobby());
		stmt.setInt(2, hobbyProfissional.getProfissional().getIdProfissional());
		
		stmt.executeUpdate();
	}
	
	/**
	 * Remove um hobbyProfissional no banco de dados
	 * @param codigo PK do profissional
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigoProf) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_HOBBY_PROFI WHERE ID_PROFISSIONAL = ?");

		stmt.setInt(1, codigoProf);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Hobby/Profissional não encontrado para ser removido");
		}
	}
	
		
}
