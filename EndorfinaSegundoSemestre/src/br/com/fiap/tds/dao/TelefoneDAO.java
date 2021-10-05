package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Telefone;

public class TelefoneDAO {

	private Connection conexao;

	public TelefoneDAO(Connection conexao) {
		this.conexao = conexao;
		
	}

	public void cadastrarUsuario(Telefone telefone) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_TEL "
				+ "(ID_TEL, ID_USUARIO, NR_NUMERO, NR_DDD, NR_DDI)"
				+ " VALUES (SQ_ENDORF_TEL.NEXTVAL, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setInt(1, telefone.getIdUsuario());
		stmt.setInt(2, telefone.getNumeroTel());
		stmt.setInt(3, telefone.getDdd());
		stmt.setInt(4, telefone.getDdi());

		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	public void cadastrarProfissional(Telefone telefone) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_TEL "
				+ "(ID_TEL, ID_PROFISSIONAL, NR_NUMERO, NR_DDD, NR_DDI)"
				+ " VALUES (SQ_ENDORF_TEL.NEXTVAL, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setInt(1, telefone.getIdProfissional());
		stmt.setInt(2, telefone.getNumeroTel());
		stmt.setInt(3, telefone.getDdd());
		stmt.setInt(4, telefone.getDdi());

		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
		//Lista e remover
	
		public void atualizar(Telefone telefone) {
			
		}
		
		public Telefone pesquisar(int codigo) {
			return null;
		}
	
	
}
