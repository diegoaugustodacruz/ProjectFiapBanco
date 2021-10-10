package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.dao.ProfissionalDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;

/**
 * Classe que contem as regras de negocios e validacoes do profissional
 * @author accountfy
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
		
		profissional.setNome(profissional.getNome().toUpperCase());
		profissional.setEmail(profissional.getEmail().toUpperCase());
		
		dao.cadastrar(profissional);
	}
}
