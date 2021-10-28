package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.dao.FuncionarioDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do funcionario
 * @author Grupo
 *
 */
public class FuncionarioBO {
	
	private FuncionarioDAO funcionarioDAO;
	private DepartamentoBO departamentoBO;
	private Connection conexao;	

	/**
	 * Construtor que recebe a conexao
	 * @param conexao
	 */
	public FuncionarioBO(Connection conexao) {
		this.conexao = conexao;
		this.funcionarioDAO = new FuncionarioDAO(conexao);
		this.departamentoBO = new DepartamentoBO(conexao);
		
	}
	
	/**
	 * Regras de negocio para cadastramento do funcionario
	 * @param funcionario Funcionario que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(Funcionario funcionario) throws SQLException, DadosInvalidosException{
		validar(funcionario);
		conexao.setAutoCommit(false);
		departamentoBO.cadastrar(funcionario.getDepartamento());
		funcionarioDAO.cadastrar(funcionario);
		
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
	public List<Funcionario> buscarPorNome(String nome) throws SQLException{
		return funcionarioDAO.buscarPorNome(nome);
	}
	
	/**
	 * Regras de negocio para atualizar um funcionario
	 * @param funcionario Funcionario com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(Funcionario funcionario) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(funcionario);
		funcionarioDAO.atualizar(funcionario);
	}

	/**
	 * Regras de negocio para pesquisar um funcionario pela sua PK
	 * @param codigo PK do funcionario
	 * @return informacoes do funcionario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Funcionario pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return funcionarioDAO.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os funcionarios cadastrados
	 * @return Lista funcionarios
	 * @throws SQLException
	 */
	public List<Funcionario> listar() throws SQLException{
		return funcionarioDAO.listar();
	}
	
	/**
	 * Remove um funcionario
	 * @param codigo PK do funcionario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		funcionarioDAO.remover(codigo);
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param funcionario Funcionario para validar
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(Funcionario funcionario) throws SQLException, DadosInvalidosException{

		if(funcionario.getNome()==null || funcionario.getNome().length()>80) {
			throw new DadosInvalidosException("Nome funcionario é obrigatorio e deve conter menos de 80 caracteres");
		}
		
		if(funcionario.getCpf()==null || funcionario.getCpf().length()>11) {
			throw new DadosInvalidosException("CPF funcionario é obrigatorio e deve conter 9 algarismos");
		}
		
		if(funcionario.getEstadoCivil()==null || funcionario.getEstadoCivil().length()>20) {
			throw new DadosInvalidosException("Estado civil funcionario é obrigatorio e deve conter 20 caracteres");
		}
		
		
	}
	
	
}
