package br.com.fiap.tds.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.AlimentoTO;

/**
 * Define o "contrato" os metodos que deve ser implementados pela classe que implementa a interface
 * @author diego
 *
 */
public interface AlimentoDAO {

	void cadastrar(AlimentoTO alimento) throws SQLException;
	
	void atualizar(AlimentoTO alimento) throws IdNotFoundException, SQLException;
	
	void remover(AlimentoTO alimento) throws IdNotFoundException, SQLException;
	
	AlimentoTO buscar(int codigo) throws IdNotFoundException, SQLException;
	
	List<AlimentoTO> listar() throws SQLException;
	
}
