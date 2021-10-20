package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bean.UsuarioProfissional;
import br.com.fiap.tds.exception.IdNotFoundException;

public class UsuarioProfissionalDAO {

	private Connection conexao;

	public UsuarioProfissionalDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrar(UsuarioProfissional usuarioProfissional) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_USUARIO_PROFI "
				+ "(ID_USUARIO, ID_PROFISSIONAL)"
				+ " VALUES (?, ?)");
		
		stmt.setInt(1, usuarioProfissional.getProfissional().getIdProfissional());
		stmt.setInt(2, usuarioProfissional.getUsuario().getIdUsuario());
		
		stmt.executeUpdate();
	}	
	
	
	public void remover(int codigoUsuario) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM ENDORF_USUARIO_PROFI WHERE ID_USUARIO = ?");

		stmt.setInt(1, codigoUsuario);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Usuario/Profissional não encontrado para ser removido");
		}
	}
	
}
