package br.com.fiap.tds.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import br.com.fiap.tds.dao.RestauranteDAO;
import br.com.fiap.tds.factory.DaoFactory;
import br.com.fiap.tds.to.RestauranteTO;

public class RestauranteBO {
	
	private RestauranteDAO restauranteDao;
	
	public RestauranteBO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		restauranteDao = DaoFactory.getRestauranteDAO();
	}
	
	public void cadastrar(RestauranteTO restaurante) throws SQLException{
		//validar...
		restauranteDao.cadastrar(restaurante);
	}

}
