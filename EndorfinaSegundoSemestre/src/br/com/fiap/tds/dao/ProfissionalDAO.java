package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Profissional;

public class ProfissionalDAO {
	
	private Connection conexao;

	public ProfissionalDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrar(Profissional profissional) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_PROFISSIONAL "
				+ "(ID_PROFISSIONAL, NM_PROFISSIONAL, DT_NASCIMENTO, DT_CADASTRO, DS_EMAIL, DS_SENHA)"
				+ " VALUES (SQ_ENDORF_PROFISSIONAL.NEXTVAL, ?, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setString(1, profissional.getNome());
		stmt.setString(2, profissional.getDataNascimento());
		stmt.setString(3, profissional.getDataCadastro());
		stmt.setString(4, profissional.getEmail());
		stmt.setString(5, profissional.getSenha());

		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
		//Lista e remover
	
		public void atualizar(Profissional profissional) {
			
		}
		
		public Profissional pesquisar(int codigo) {
			return null;
		}

}
