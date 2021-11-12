package br.com.fiap.tds.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.dao.EnderecoDAO;
import br.com.fiap.tds.dao.SupermercadoDAO;
import br.com.fiap.tds.dao.TelefoneDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.DaoFactory;
import br.com.fiap.tds.to.SupermercadoTO;

/**
 * Classe que contem as regras de negocios e validacoes do supermercado
 * @author Diego
 *
 */
public class SupermercadoBO {
	
	private SupermercadoDAO supermercadoDao;
	
	/**
	 * Construtor que inicializa a conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public SupermercadoBO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		supermercadoDao = DaoFactory.getSupermercadoDAO();

	}
	
	
	/**
	 * Regras de negocio para cadastramento do supermercado
	 * @param supermercado Supermercado que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(SupermercadoTO supermercado) throws SQLException, DadosInvalidosException{
		validar(supermercado);		
		supermercadoDao.cadastrar(supermercado);
	}
	
	/**
	 * Regras de negocio para buscar informacoes pelo nome de um supermercado
	 * @param nome Nome do supermercado
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<SupermercadoTO> buscarPorNome(String nome) throws SQLException{
		return supermercadoDao.buscarPorNome(nome);
	}

	/**
	 * Regras de negocio para atualizar um supermercado
	 * @param supermercado Supermercado com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(SupermercadoTO supermercado) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(supermercado);

		supermercadoDao.atualizar(supermercado);
	}
	
	/**
	 * Regras de negocio para pesquisar um supermercado pela sua PK
	 * @param codigo PK do supermercado
	 * @return informacoes do supermercado
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public SupermercadoTO pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return supermercadoDao.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os supermercados cadastrados
	 * @return Lista supermercado
	 * @throws SQLException
	 */
	public List<SupermercadoTO> listar() throws SQLException{
		return supermercadoDao.listar();
	}
	
	/**
	 * Remove um supermercado
	 * @param codigo PK do supermercado
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		supermercadoDao.remover(codigo);		
		
		
	}	
	
	/**
	 * Validacao das regras de negocio
	 * @param supermercado Supermercado para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(SupermercadoTO supermercado)  throws SQLException, DadosInvalidosException{
		
		if(supermercado.getNome()==null || supermercado.getNome().length()>90) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 90 caracteres");
		}
		
		if(supermercado.getCnpj()==null || supermercado.getCnpj().length()>14) {
			throw new DadosInvalidosException("CNPJ é obrigatorio e deve conter menos de 14 caracteres");
		}		
		
		if(supermercado.getEmail()==null || supermercado.getEmail().length()>35) {
			throw new DadosInvalidosException("Email é obrigatorio e deve conter menos de 35 caracteres");
		}		
		
		if(supermercado.getSenha()==null || supermercado.getSenha().length()>20) {
			throw new DadosInvalidosException("Senha é obrigatorio e deve conter menos de 20 caracteres");
		}
	}

	
	
}
