package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.dao.ProfissionalDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do profissional
 * @author Endorfina
 *
 */
public class ProfissionalBO {
	
	private ProfissionalDAO dao;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDateTime now = LocalDateTime.now();
	String hoje = dtf.format(now);
	int diaAtual = Integer.parseInt(hoje.substring(0, 2));
	int mesAtual = Integer.parseInt(hoje.substring(3, 5));
	int anoAtual = Integer.parseInt(hoje.substring(6));
	
	/**
	 * Construtor que recebe a conexao
	 * @param conexao
	 */
	public ProfissionalBO(Connection conexao) {
		dao = new ProfissionalDAO(conexao);
	}
	
	/**
	 * Regras de negocio para cadastramento do profissional
	 * @param profissional Profissional que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(Profissional profissional) throws SQLException, DadosInvalidosException{
		validar(profissional);		
		
		dao.cadastrar(profissional);
	}
	
	/**
	 * Regras de negocio para buscar informacoes pelo nome de um profissional
	 * @param nome Nome do profissional
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<Profissional> buscarPorNome(String nome) throws SQLException{
		return dao.buscarPorNome(nome);
	}
	
	/**
	 * Regras de negocio para atualizar um profissional
	 * @param profissional Profissional com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(Profissional profissional) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(profissional);		
		dao.atualizar(profissional);
	}	
		
	/**
	 * Regras de negocio para pesquisar um profissional pela sua PK
	 * @param codigo PK do profissional
	 * @return informacoes do profissional
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Profissional pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return dao.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os profissionais cadastrados
	 * @return Lista profissionais
	 * @throws SQLException
	 */
	public List<Profissional> listar() throws SQLException{
		return dao.listar();
	}
	
	
	/**
	 * Remove um profissional
	 * @param codigo PK do profisisonal
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		dao.remover(codigo);
	}
	
	/**
	 * Validacao das regras de negocio
	 * @param profissional Profissional para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(Profissional profissional) throws SQLException, DadosInvalidosException{
		int diaNascimento = Integer.parseInt(profissional.getDataNascimento().substring(0, 2));
		int mesNascimento = Integer.parseInt(profissional.getDataNascimento().substring(3,5));
		int anoNascimento = Integer.parseInt(profissional.getDataNascimento().substring(6));
		
		if(profissional.getNome()==null || profissional.getNome().length()>80) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 80 caracteres");
		}
		
		if(profissional.getDataNascimento()==null) {
			throw new DadosInvalidosException("Data de Nascimento válida é obrigatoria");
		}
		
		if(anoNascimento >= anoAtual) {
			if(mesNascimento >= mesAtual) {
				if(diaNascimento>diaAtual) {
					throw new DadosInvalidosException("Data de Nascimento válida é obrigatoria");
				}
			}	
		}
		
		if(profissional.getEmail()==null || profissional.getEmail().length()>50) {
			throw new DadosInvalidosException("Email é obrigatorio e deve conter menos de 50 caracteres");
		}		
		
		if(profissional.getSenha()==null || profissional.getSenha().length()>20) {
			throw new DadosInvalidosException("Senha é obrigatorio e deve conter menos de 50 caracteres");
		}
	}
}

