package br.com.fiap.tds.dao;

import java.sql.SQLException;

import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.DoacaoVendaTO;

public interface DoacaoVendaDAO {

	void cadastrar(DoacaoVendaTO doacaoVenda) throws SQLException;
	
	void remover(int codigoDoacaoVenda) throws SQLException, IdNotFoundException;
}
