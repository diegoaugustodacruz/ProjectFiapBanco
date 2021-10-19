package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.Pedido;
import br.com.fiap.tds.dao.PedidoDao;
import br.com.fiap.tds.exception.DadoInvalidoException;

public class PedidoBo {

	private PedidoDao pedidoDao;
	private NotaFiscalBo notaBo;
	private Connection conexao;
	
	public PedidoBo(Connection conexao) {
		this.conexao = conexao;
		this.pedidoDao = new PedidoDao(conexao);
		this.notaBo = new NotaFiscalBo(conexao);
	}
	
	public void cadastrar(Pedido pedido) throws SQLException, DadoInvalidoException {
		//Desabilitar o autocomit
		conexao.setAutoCommit(false);
		
		notaBo.cadastrar(pedido.getNota());
		pedidoDao.cadastrar(pedido);
		
		try {
			conexao.commit();
		} catch (Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar o commit");
		}
	}
}