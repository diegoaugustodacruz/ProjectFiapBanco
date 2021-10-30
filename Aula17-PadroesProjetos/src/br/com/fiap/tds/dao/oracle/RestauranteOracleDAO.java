package br.com.fiap.tds.dao.oracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.dao.RestauranteDAO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.AlimentoTO;
import br.com.fiap.tds.to.RestauranteTO;

public class RestauranteOracleDAO implements RestauranteDAO{
	
	private Connection conexao;
	
	public RestauranteOracleDAO(Connection conexao) {
		this.conexao = conexao;

	}


	@Override
	public void cadastrar(RestauranteTO restaurante) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void atualizar(RestauranteTO restaurante) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void remover(RestauranteTO restaurante) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}	
	
	
	@Override
	public List<RestauranteTO> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<RestauranteTO> buscarPorNome(String Nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AlimentoTO buscarPorCodigo(int codigo) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Metodo chamado automaticamente pelo java quando o objeto é finalizado, destruido
	@Override
	protected void finalize() throws Throwable{
		conexao.close();
	}
}
