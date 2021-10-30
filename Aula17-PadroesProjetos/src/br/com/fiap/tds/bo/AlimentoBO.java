package br.com.fiap.tds.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.dao.AlimentoDAO;
import br.com.fiap.tds.dao.oracle.AlimentoOracleDAO;
import br.com.fiap.tds.factory.DaoFactory;
import br.com.fiap.tds.to.AlimentoTO;

/**
 * Classe com regras de negocio e validacoes
 * @author Diego
 *
 */
public class AlimentoBO {	

	private AlimentoDAO alimentoDao;
	
	public AlimentoBO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		alimentoDao = DaoFactory.getAlimentoDAO();
	}

	public void cadastrar(AlimentoTO alimento) throws SQLException{
		//validar...
		alimentoDao.cadastrar(alimento);
	}
	
}
