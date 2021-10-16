package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Pedido;

public class PedidoDao {

	private Connection conexao;
	
	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public PedidoDao(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	public void cadastrar(Pedido pedido) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO TDS_TB_PEDIDO "
				+ "(CD_PEDIDO, DT_PEDIDO, CD_NOTA) "
				+ "VALUES (SQ_TDSS_TB_PEDIDO.NEXTVAL, ?, ?)");
		
		//passar os valores para o comando SQL
		Date data = Date.valueOf(pedido.getData().toString());
		stmt.setDate(1, data);
		stmt.setInt(2, pedido.getNota().getCodigo());
		
		//Executar o comando SQL
		stmt.executeUpdate();
	}
}
