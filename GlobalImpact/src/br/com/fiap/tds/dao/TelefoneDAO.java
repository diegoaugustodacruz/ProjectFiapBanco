package br.com.fiap.tds.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.TelefoneTO;

public interface TelefoneDAO {

	public List<TelefoneTO> buscarPorNumero(int ddd) throws SQLException;
	
	public void cadastrar(TelefoneTO telefone) throws SQLException;
	
	public void atualizar(TelefoneTO telefone) throws SQLException, IdNotFoundException;
	
	public TelefoneTO pesquisar(int codigo) throws SQLException, IdNotFoundException;
	
	public List<TelefoneTO> listar() throws SQLException;
	
	public void remover(int codigo) throws SQLException, IdNotFoundException;
}
