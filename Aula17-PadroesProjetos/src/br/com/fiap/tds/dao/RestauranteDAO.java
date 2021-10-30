package br.com.fiap.tds.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.AlimentoTO;
import br.com.fiap.tds.to.RestauranteTO;

public interface RestauranteDAO {

	void cadastrar(RestauranteTO restaurante) throws SQLException;
	
	void atualizar(RestauranteTO restaurante) throws IdNotFoundException, SQLException;
	
	void remover(RestauranteTO restaurante) throws IdNotFoundException, SQLException;	
	
	List<RestauranteTO> listar() throws SQLException;
	
	List<RestauranteTO> buscarPorNome(String Nome) throws SQLException;
	
	AlimentoTO buscarPorCodigo(int codigo) throws IdNotFoundException, SQLException;

	
	
}
