package br.com.fiap.tds.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.dao.SupermercadoDAO;
import br.com.fiap.tds.dao.TelefoneDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.DaoFactory;
import br.com.fiap.tds.singleton.ConnectionManager;
import br.com.fiap.tds.to.TelefoneTO;

/**
 * Classe que contem as regras de negocios e validacoes do telefone
 * @author Diego
 *
 */
public class TelefoneBO {
	
	private TelefoneDAO telefoneDao;
	private SupermercadoDAO supermercadoDao;
	private Connection conexao;

	
	/**
	 * Construtor que incializa a conexao
	 * @param conexao
	 */
	public TelefoneBO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		this.telefoneDao = DaoFactory.getTelefoneDAO();
		this.supermercadoDao = DaoFactory.getSupermercadoDAO();
		this.conexao = ConnectionManager.getInstance().getConnection();
	}
	
	/**
	 * Regras de negocio para cadastramento do telefone de um usuario
	 * @param telefone Telefone que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(TelefoneTO telefone) throws SQLException, DadosInvalidosException{
		validar(telefone);
		conexao.setAutoCommit(false);
		supermercadoDao.cadastrar(telefone.getSupermercado());
		telefoneDao.cadastrar(telefone);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}
		
	}
	
	
	
	/**
	 * Regras de negocio para buscar informacoes pelo nmmero de telefone
	 * @param numero Numero de telefone
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<TelefoneTO> buscarPorNumero(int numero) throws SQLException{
		return telefoneDao.buscarPorNumero(numero);
	}
	
	/**
	 * Regras de negocio para atualizar um telefone
	 * @param telefone Telefone com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(TelefoneTO telefone) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(telefone);
		telefoneDao.atualizar(telefone);
	}

	/**
	 * Regras de negocio para pesquisar um telefone pela sua PK
	 * @param codigo PK do telefone
	 * @return informacoes do telefone
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public TelefoneTO pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return telefoneDao.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os telefones cadastrados
	 * @return Lista telefones
	 * @throws SQLException
	 */
	public List<TelefoneTO> listar() throws SQLException{
		return telefoneDao.listar();
	}
	
	/**
	 * Remove um telefone
	 * @param codigo PK do telefone
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		telefoneDao.remover(codigo);
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param telefone Telefone para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	private void validar(TelefoneTO telefone) throws SQLException, DadosInvalidosException{
		String numeroTelefone = Integer.toString(telefone.getNumeroTel());
		String numeroDDD = Integer.toString(telefone.getDdd());

		if(numeroTelefone == null || numeroTelefone.length()>9) {
			throw new DadosInvalidosException("Numero telefone é obrigatorio e deve conter 9 algarismos");
		}
		
		if(numeroDDD == null || numeroDDD.length()>3) {
			throw new DadosInvalidosException("Numero ddd é obrigatorio e deve conter 3 algarismos");
		}
		
		if(telefone.getDdi() == null || telefone.getDdi().length()>3) {
			throw new DadosInvalidosException("Numero ddi é obrigatorio e deve conter 3 algarismos");
		}
	}
	
	
	
}
