package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Usuario;

public class UsuarioDao {
	
	private Connection conexao;

	public UsuarioDao(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrar(Usuario usuario) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_USUARIO "
				+ "(ID_USUARIO, NM_USUARIO, DT_NASCIMENTO, DT_CADASTRO, DS_EMAIL, DS_SENHA)"
				+ " VALUES (SQ_ENDORF_USUARIO.NEXTVAL, ?, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getDataNascimento());
		stmt.setString(3, usuario.getDataCadastro());
		stmt.setString(4, usuario.getEmail());
		stmt.setString(5, usuario.getSenha());

		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
		//Lista e remover
	
		public void atualizar(Usuario usuario) {
			
		}
		
		public Usuario pesquisar(int codigo) {
			return null;
		}
	
}
