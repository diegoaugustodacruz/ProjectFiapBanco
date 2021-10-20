package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.HobbyProfissional;
import br.com.fiap.tds.exception.IdNotFoundException;

public class HobbyProfissionalDAO {

	private Connection conexao;

	public HobbyProfissionalDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrar(HobbyProfissional hobbyProfissional) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_HOBBY_PROFISSIONAL "
				+ "(ID_HOBBY, ID_PROFISSIONAL)"
				+ " VALUES (?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setInt(1, hobbyProfissional.getHobby().getIdHobby());
		stmt.setInt(2, hobbyProfissional.getProfissional().getIdProfissional());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	public void remover(int codigoProf) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_HOBBY_PROFI WHERE ID_PROFISSIONAL = ?");

		stmt.setInt(1, codigoProf);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Hobby/Profissional não encontrado para ser removido");
		}
	}
	
		
}
