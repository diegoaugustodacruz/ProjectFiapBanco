package br.com.fiap.tds.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.EnderecoTO;

public interface EnderecoDAO {
	
void cadastrar(EnderecoTO endereco) throws SQLException;
	
	void atualizar(EnderecoTO endereco) throws IdNotFoundException, SQLException;
	
	void remover(int codigo) throws SQLException, IdNotFoundException;
	
	EnderecoTO pesquisar(int codigo) throws IdNotFoundException, SQLException;
	
	List<EnderecoTO> listar() throws SQLException;

	List<EnderecoTO> buscarPorNome(String nome) throws SQLException;

}
