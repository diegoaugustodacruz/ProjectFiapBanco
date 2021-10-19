package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.tds.bean.NotaFiscal;
import br.com.fiap.tds.dao.NotaFiscalDao;
import br.com.fiap.tds.exception.DadoInvalidoException;

public class NotaFiscalBo {

	private NotaFiscalDao notaDao;
	
	public NotaFiscalBo(Connection conexao) {
		this.notaDao = new NotaFiscalDao(conexao);
	}
	
	public void cadastrar(NotaFiscal nota) throws SQLException, DadoInvalidoException {
		validar(nota);
		notaDao.cadastrar(nota);
	}

	private void validar(NotaFiscal nota) throws DadoInvalidoException {
		if (nota.getValor() < 0) {
			throw new DadoInvalidoException("O valor não pode ser negativo");
		}
	}
}
