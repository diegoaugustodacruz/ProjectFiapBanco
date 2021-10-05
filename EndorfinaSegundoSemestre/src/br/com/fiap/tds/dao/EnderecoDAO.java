package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Endereco;

public class EnderecoDAO {

	private Connection conexao;

	public EnderecoDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	public void cadastrarUsuario(Endereco endereco) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_END "
				+ "(ID_END, NM_RUA, NR_NUMERO, NR_CEP, NM_BAIRRO, NM_CIDADE, NM_ESTADO, ID_USUARIO)"
				+ " VALUES (SQ_ENDORF_END.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setString(1, endereco.getNomeRua());
		stmt.setInt(2, endereco.getNumeroCasa());
		stmt.setInt(3, endereco.getNumeroCEP());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setInt(7, endereco.getIdUsuario());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	public void cadastrarProfissional(Endereco endereco) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO ENDORF_END "
				+ "(ID_END, NM_RUA, NR_NUMERO, NR_CEP, NM_BAIRRO, NM_CIDADE, NM_ESTADO, ID_PROFISSIONAL)"
				+ " VALUES (SQ_ENDORF_END.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
		
		//passar os valores para o comando SQL
		stmt.setString(1, endereco.getNomeRua());
		stmt.setInt(2, endereco.getNumeroCasa());
		stmt.setInt(3, endereco.getNumeroCEP());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setInt(7, endereco.getIdProfissional());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
	
	
		//Lista e remover
	
		public void atualizar(Endereco endereco) {
			
		}
		
		public Endereco pesquisar(int codigo) {
			return null;
		}
}
