package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.dao.UsuarioDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do usuario
 * @author Enforfina
 *
 */
public class UsuarioBO {	
	
	private UsuarioDAO dao;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDateTime now = LocalDateTime.now();
	String hoje = dtf.format(now);
	int diaAtual = Integer.parseInt(hoje.substring(0, 2));
	int mesAtual = Integer.parseInt(hoje.substring(3, 5));
	int anoAtual = Integer.parseInt(hoje.substring(6));
	
	/**
	 * Construtor que recebe a conexao 
	 * @param conexao conexao com o banco de dados
	 */
	public UsuarioBO(Connection conexao) {
		dao = new UsuarioDAO(conexao);
	}

	/**
	 * Regras de negocio para cadastramento do usuario
	 * @param usuario Usuario que sera cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void cadastrar(Usuario usuario) throws SQLException, DadosInvalidosException{
		validar(usuario);		
		
		dao.cadastrar(usuario);
	}
	
	/**
	 * Regras de negocio para buscar informacoes pelo nome de um usuario
	 * @param nome Nome do usuario
	 * @return retorna lista com as informacoes
	 * @throws SQLException
	 */
	public List<Usuario> buscarPorNome(String nome) throws SQLException{
		return dao.buscarPorNome(nome);
	}

	/**
	 * Regras de negocio para atualizar um usuario
	 * @param usuario Usuario com valores a serem atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws DadosInvalidosException
	 */
	public void atualizar(Usuario usuario) throws SQLException, IdNotFoundException, DadosInvalidosException{
		validar(usuario);

		dao.atualizar(usuario);
	}
	
	/**
	 * Regras de negocio para pesquisar um usuario pela sua PK
	 * @param codigo PK do usuario
	 * @return informacoes do usuario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Usuario pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return dao.pesquisar(codigo);
	}
	
	/**
	 * Regras de negocio para listar os usuarios cadastrados
	 * @return Lista usuarios
	 * @throws SQLException
	 */
	public List<Usuario> listar() throws SQLException{
		return dao.listar();
	}
	
	/**
	 * Remove um usuario
	 * @param codigo PK do usuario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		dao.remover(codigo);
	}	
	
	/**
	 * Validacao das regras de negocio
	 * @param usuario Usuario para ser cadastrado
	 * @throws SQLException
	 * @throws DadosInvalidosException
	 */
	public void validar(Usuario usuario)  throws SQLException, DadosInvalidosException{
		int diaNascimento = Integer.parseInt(usuario.getDataNascimento().substring(0, 2));
		int mesNascimento = Integer.parseInt(usuario.getDataNascimento().substring(3,5));
		int anoNascimento = Integer.parseInt(usuario.getDataNascimento().substring(6));
		
		if(usuario.getNome()==null || usuario.getNome().length()>80) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 80 caracteres");
		}
		
		if(usuario.getDataNascimento()==null) {
			throw new DadosInvalidosException("Data de Nascimento válida é obrigatoria");
		}
		
		if(anoNascimento >= anoAtual) {
			if(mesNascimento >= mesAtual) {
				if(diaNascimento>diaAtual) {
					throw new DadosInvalidosException("Data de Nascimento válida é obrigatoria");
				}
			}	
		}
		
		if(usuario.getEmail()==null || usuario.getEmail().length()>50) {
			throw new DadosInvalidosException("Email é obrigatorio e deve conter menos de 50 caracteres");
		}		
		
		if(usuario.getSenha()==null || usuario.getSenha().length()>20) {
			throw new DadosInvalidosException("Senha é obrigatorio e deve conter menos de 50 caracteres");
		}
	}
}
