package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.tds.bean.NotaFiscal;

public class NotaFiscalDao {

	private Connection conexao;
	
	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public NotaFiscalDao(Connection conexao) {
		this.conexao = conexao;
	}


	public void cadastrar(NotaFiscal nf) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO TDSS_TB_NOTA_FISCAL "
				+ "(CD_NOTA, VL_NOTA) "
				+ "VALUES (SQ_TB_NOTA_FISCAL.NEXTVAL, ?)", new String[] {"cd_nota"});
		
		//passar os valores para o comando SQL
		stmt.setDouble(1, nf.getValor());
		
		//Executar o comando SQL
		stmt.executeUpdate();
		
		//Recuperar o id gerado pela sequence
		ResultSet result = stmt.getGeneratedKeys();
		if(result.next()) {
			int codigo = result.getInt(1);
			nf.setCodigo(codigo);
		}
	}



}



