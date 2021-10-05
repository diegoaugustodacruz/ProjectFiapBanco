package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.UsuarioProfissional;

public class UsuarioProfissionalDAO {

	private Connection conexao;

	public UsuarioProfissionalDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrarUsuario(UsuarioProfissional usuarioProfissional) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_USUARIO_PROFI "
				+ "(ID_USUARIO, ID_PROFISSIONAL)"
				+ " VALUES (?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setInt(1, usuarioProfissional.getIdUsuario());
		stmt.setInt(2, usuarioProfissional.getIdProfissional());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	
		//Lista e remover
	
		public void atualizar(UsuarioProfissional usuarioProfissional) {
			
		}
		
		public UsuarioProfissional pesquisar(int codigo) {
			return null;
		}
	
}
