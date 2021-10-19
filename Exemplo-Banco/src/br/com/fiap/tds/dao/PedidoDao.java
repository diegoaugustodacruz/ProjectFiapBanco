package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.fiap.tds.bean.Pedido;

public class PedidoDao {

	private Connection conexao;
	
	public PedidoDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Pedido pedido) throws SQLException {
		//Criar o comando SQL
		PreparedStatement stmt = conexao.prepareStatement("insert into t_pedido "
				+ "(cd_pedido, dt_pedido, cd_nota) values (sq_tdss_tb_pedido.nextval, ?, ?)");
		
		//Setar os valores
		Date data = Date.valueOf(pedido.getData().toString());
		stmt.setDate(1, data);
		stmt.setInt(2, pedido.getNota().getCodigo());
		
		//Executar a query
		stmt.executeUpdate();
	}
}