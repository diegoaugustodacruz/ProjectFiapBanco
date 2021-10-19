package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.ItemPedido;
import br.com.fiap.tds.dao.ItemPedidoDao;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contém as regras de negócio e validações
 * @author Thiago Yamamoto
 */
public class ItemPedidoBo {

	private ItemPedidoDao itemDao;
	
	public ItemPedidoBo(Connection conection) {
		itemDao = new ItemPedidoDao(conection);
	}
	
	/**
	 * Cadastra um item de pedido
	 * @param item
	 * @throws SQLException
	 */
	public void cadastrar(ItemPedido item) throws SQLException {
		itemDao.cadastrar(item);
	}
	
	/**
	 * Remove um item d e pedido
	 * @param codigoProduto
	 * @param codigoPedido
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigoProduto, int codigoPedido) throws SQLException, IdNotFoundException {
		itemDao.remover(codigoProduto, codigoPedido);
	}
	
}
