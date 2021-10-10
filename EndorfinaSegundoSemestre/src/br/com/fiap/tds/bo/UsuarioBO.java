package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	 * @param conexao
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
		
		usuario.setNome(usuario.getNome().toUpperCase());
		usuario.setEmail(usuario.getEmail().toUpperCase());
		
		dao.cadastrar(usuario);
	}
	
	public void atualizar(Usuario usuario) throws SQLException, IdNotFoundException{
		dao.atualizar(usuario);
	}
}
