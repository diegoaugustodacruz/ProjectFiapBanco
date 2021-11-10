package br.com.fiap.tds.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.ProdutoTO;

public interface ProdutoDAO {

void cadastrar(ProdutoTO produto) throws SQLException;
	
	void atualizar(ProdutoTO produto) throws IdNotFoundException, SQLException;
	
	void remover(int codigo) throws SQLException, IdNotFoundException;
	
	ProdutoTO pesquisar(int codigo) throws IdNotFoundException, SQLException;
	
	List<ProdutoTO> listar() throws SQLException;

	List<ProdutoTO> buscarPorNome(String nome) throws SQLException;
}
