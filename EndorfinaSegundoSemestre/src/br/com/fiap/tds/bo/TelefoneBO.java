package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Endereco;
import br.com.fiap.tds.bean.Telefone;
import br.com.fiap.tds.dao.EnderecoDAO;
import br.com.fiap.tds.dao.TelefoneDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do telefone
 * @author Endorfina
 *
 */
public class TelefoneBO {
	
	private TelefoneDAO telefoneDAO;
	private UsuarioBO usuarioBO;
	private ProfissionalBO profissionalBO;
	private Connection conexao;
	
	/**
	 * Construtor que recebe a conexao
	 * @param conexao
	 */
	public TelefoneBO(Connection conexao) {
		this.conexao = conexao;
		this.telefoneDAO = new TelefoneDAO(conexao);
		this.profissionalBO = new ProfissionalBO(conexao);
		this.usuarioBO = new UsuarioBO(conexao);
		
	}
	
	/**
	 * Regras de negocio para cadastramento do telefone de um usuario
	 * @param telefone Telefone que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrarUsuario(Telefone telefone) throws SQLException, DadosInvalidosException{
		validar(telefone);
		conexao.setAutoCommit(false);
		usuarioBO.cadastrar(telefone.getUsuario());
		telefoneDAO.cadastrarUsuario(telefone);
		
		try {
			conexao.commit();
		}catch(Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar commit");
		}
	}
	
	/**
	 * Regras de negocio para cadastramento do telefone de um profissional
	 * @param telefone Telefone que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrarProfissional(Telefone telefone) throws SQLException, DadosInvalidosException{
		validar(telefone);
		conexao.setAutoCommit(false);
		profissionalBO.cadastrar(telefone.getProfissional());
		telefoneDAO.cadastrarProfissional(telefone);
		
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
	public List<Telefone> buscarPorNumero(int numero) throws SQLException{
		return telefoneDAO.buscarPorNumero(numero);
	}
	
	/**
	 * Regras de negocio para atualizar um telefone
	 * @param telefone Telefone com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(Telefone telefone) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(telefone);
		telefoneDAO.atualizar(telefone);
	}

	/**
	 * Regras de negocio para pesquisar um telefone pela sua PK
	 * @param codigo PK do telefone
	 * @return informacoes do telefone
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Telefone pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return telefoneDAO.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os telefones cadastrados
	 * @return Lista telefones
	 * @throws SQLException
	 */
	public List<Telefone> listar() throws SQLException{
		return telefoneDAO.listar();
	}
	
	/**
	 * Remove um telefone
	 * @param codigo PK do telefone
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		telefoneDAO.remover(codigo);
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param telefone Telefone para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	private void validar(Telefone telefone) throws SQLException, DadosInvalidosException{
		String numeroTelefone = Integer.toString(telefone.getNumeroTel());
		String numeroDDD = Integer.toString(telefone.getDdd());
		String numeroDDI = Integer.toString(telefone.getDdi());

		if(numeroTelefone == null || numeroTelefone.length()>9) {
			throw new DadosInvalidosException("Numero telefone é obrigatorio e deve conter 9 algarismos");
		}
		
		if(numeroDDD == null || numeroDDD.length()>3) {
			throw new DadosInvalidosException("Numero ddd é obrigatorio e deve conter 3 algarismos");
		}
		
		if(numeroDDI == null || numeroDDI.length()>3) {
			throw new DadosInvalidosException("Numero ddi é obrigatorio e deve conter 3 algarismos");
		}
	}
	
	
	
}
