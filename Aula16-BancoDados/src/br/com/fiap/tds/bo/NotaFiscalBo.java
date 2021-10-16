package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.NotaFiscal;
import br.com.fiap.tds.dao.NotaFiscalDao;
import br.com.fiap.tds.exception.DadosInvalidosException;

public class NotaFiscalBo {

	private NotaFiscalDao dao;
	
	public NotaFiscalBo(Connection conexao) {
		dao = new NotaFiscalDao(conexao);
	}
	
	public void cadastrar(NotaFiscal nota)  throws SQLException, DadosInvalidosException{
		validar(nota);
		dao.cadastrar(nota);
	}
	
	private void validar(NotaFiscal nota) throws DadosInvalidosException{
		if(nota.getValor()<0) {
			throw new DadosInvalidosException("O valor não pode ser negativo");
		}
	}
}
