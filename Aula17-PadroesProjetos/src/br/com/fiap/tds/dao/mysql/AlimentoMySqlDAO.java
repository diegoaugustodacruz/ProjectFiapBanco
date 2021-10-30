package br.com.fiap.tds.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.dao.AlimentoDAO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.AlimentoTO;

public class AlimentoMySqlDAO implements AlimentoDAO {
	
	private Connection conexao;
	
	public AlimentoMySqlDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	@Override
	public void cadastrar(AlimentoTO alimento) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(AlimentoTO alimento) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AlimentoTO alimento) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AlimentoTO buscar(int codigo) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlimentoTO> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	//Metodo chamado automaticamente pelo java quando o objeto é finalizado, destruido
	@Override
	protected void finalize() throws Throwable{
		conexao.close();
	}
}
