package br.com.fiap.tds.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.dao.EnderecoDAO;
import br.com.fiap.tds.dao.SupermercadoDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.DaoFactory;
import br.com.fiap.tds.singleton.ConnectionManager;
import br.com.fiap.tds.to.EnderecoTO;

/**
 * Classe que contem as regras de negocios e validacoes do endereco
 * @author Diego
 *
 */
public class EnderecoBO {
	
	private EnderecoDAO enderecoDao;
	private SupermercadoDAO supermercadoDao;
	private Connection conexao;


	/**
	 * Construtor que inicializa a conexao
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public EnderecoBO() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		this.enderecoDao = DaoFactory.getEnderecoDAO();
		this.supermercadoDao = DaoFactory.getSupermercadoDAO();
		this.conexao = ConnectionManager.getInstance().getConnection();

	}	
	
	/**
	 * Regras de negocio para cadastramento do endereco de um usuario
	 * @param endereco Endereco que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(EnderecoTO endereco) throws SQLException, DadosInvalidosException{
		validar(endereco);
		conexao.setAutoCommit(false);
		supermercadoDao.cadastrar(endereco.getSupermercado());
		enderecoDao.cadastrar(endereco);	
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}
		
	}
	
	
	
	/**
	 * Regras de negocio para buscar informacoes pelo nome da rua de um endereco
	 * @param nome Nome de rua
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<EnderecoTO> buscarPorNome(String nome) throws SQLException{
		return enderecoDao.buscarPorNome(nome);
	}
	
	/**
	 * Regras de negocio para atualizar um endereco
	 * @param endereco Endereco com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(EnderecoTO endereco) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(endereco);
		enderecoDao.atualizar(endereco);
	}
	
	/**
	 * Regras de negocio para pesquisar um endereco pela sua PK
	 * @param codigo PK do endereco
	 * @return informacoes do endereco
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public EnderecoTO pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return enderecoDao.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os enderecos cadastrados
	 * @return Lista enderecos
	 * @throws SQLException
	 */
	public List<EnderecoTO> listar() throws SQLException{
		return enderecoDao.listar();
	}
	
	/**
	 * Remove um endereco
	 * @param codigo PK do endereco
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		enderecoDao.remover(codigo);
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param endereco Endereco para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(EnderecoTO endereco) throws SQLException, DadosInvalidosException{

		if(endereco.getCidade()==null || endereco.getCidade().length()>50) {
			throw new DadosInvalidosException("Nome cidade é obrigatoria e deve conter menos de 50 caracteres");
		}
		
		if(endereco.getEstado()==null || endereco.getEstado().length()>50) {
			throw new DadosInvalidosException("Nome estado é obrigatoria e deve conter menos de 50 caracteres");
		}
		
		if(endereco.getNomeRua()==null ||endereco.getNomeRua().length()>170) {
			throw new DadosInvalidosException("Nome rua é obrigatória e deve conter menos de 170 caracteres");
		}
		
		if(endereco.getBairro()==null ||endereco.getBairro().length()>50) {
			throw new DadosInvalidosException("Nome bairro é obrigatório e deve conter menos de 50 caracteres");
		}
		
		if(endereco.getNumeroCEP()==null ||endereco.getNumeroCEP().length()>50) {
			throw new DadosInvalidosException("CEP é obrigatório e deve conter menos de 50 caracteres");

		}
	}
	
}