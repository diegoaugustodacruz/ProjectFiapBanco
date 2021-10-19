package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.tds.bean.NotaFiscal;

public class NotaFiscalDao {

	private Connection conexao;

	public NotaFiscalDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(NotaFiscal nota) throws SQLException {
		// Comando SQL
		PreparedStatement stmt = conexao.prepareStatement(
				"insert into t_nota_fiscal (cd_nota, vl_nota) " + " values (sq_t_nota_fiscal.nextval, ?)",
				new String[] { "cd_nota" });

		// Setar os parâmetros
		stmt.setDouble(1, nota.getValor());

		// Executar a query
		stmt.executeUpdate();

		// Recuperar o id gerado pela sequence
		ResultSet result = stmt.getGeneratedKeys();
		if (result.next()) {
			int codigo = result.getInt(1);
			nota.setCodigo(codigo);
		}
	}
}
