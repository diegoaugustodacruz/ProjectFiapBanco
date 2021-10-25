package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basicas com o departamento no banco
 * @author Grupo
 *
 */
public class DepartamentoDAO {

	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	
	public DepartamentoDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	
	/**
	 * Pesquisa os departamentos por parte do nome
	 * @param nome Termo de pesquisa
	 * @return List<Departamento> Lista dos departamentos encontrados
	 * @throws SQLException
	 */
	public List<Departamento> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SIP_DEPTO WHERE NM_DEPTO LIKE ?");

		stmt.setString(1,"%" + nome + "%");		
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);	
		
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Usuario> lista de usuarios
	 * @throws SQLException
	 */
	private List<Departamento> parseList(ResultSet result) throws SQLException{
		List<Departamento> lista = new ArrayList<Departamento>();
		
		while(result.next()) {			
			Departamento departamento = parse(result);
			lista.add(departamento);
		}
		return lista;
		
	}
	
	/**
	 * Cadastra um departamento no banco de dados
	 * @param departamento Departamento com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrar(Departamento departamento) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_SIP_DEPTO "
				+ "(CD_DEPTO, NM_DEPTO, DS_SIGLA)"
				+ " VALUES (SQ_T_SIP_DEPTO.NEXTVAL, ?, ?)", new String[] {"CD_DEPTO"});
		
		stmt.setString(1, departamento.getNome());
		stmt.setString(2, departamento.getSigla());
	

		
		stmt.executeUpdate();
		
		ResultSet result = stmt.getGeneratedKeys();
		if(result.next()) {
			int codigo = result.getInt(1);
			departamento.setCodigo(codigo);
		}
	}
	
	/**
	 * Atualiza departamento no banco de dados
	 * @param departamento Departamento com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Departamento departamento) throws SQLException, IdNotFoundException{
		pesquisar(departamento.getCodigo());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE T_SIP_DEPTO SET NM_DEPTO = ?, DS_SIGLA = ?");
		stmt.setString(1, departamento.getNome());
		stmt.setString(2, departamento.getSigla());		

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Departamento não encontrado");
		}
		
	}
	
	/**
	 * Pesquisa um departamento no banco de dados pela PK
	 * @param codigo PK do departamento
	 * @return Departamento Departamento com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Departamento pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SIP_DEPTO WHERE CD_DEPTO = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Departamento não encontrado");
			
		}
		
		Departamento departamento = parse(result);
		
		return departamento;
	}
	
	/**
	 * Retorna todos os departamentos do banco de dados
	 * @return List<Departamento> Lista de departamentos
	 * @throws SQLException
	 */
	public List<Departamento> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SIP_DEPTO");
		
		ResultSet result = stmt.executeQuery();

		List<Departamento> lista = new ArrayList<Departamento>();

		while(result.next()) {			
			Departamento departamento = parse(result);
			lista.add(departamento);
		}
		return lista;
	}
	
	/**
	 * Recupera as informacoes de um registro do banco e retorna o departamento
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Departamento departamento com os valores do banco de dados
	 * @throws SQLException
	 */
	private Departamento parse(ResultSet result) throws SQLException {

		int codigo = result.getInt("CD_DEPTO");
		String nome = result.getString("NM_DEPTO");
		String sigla = result.getString("DS_SIGLA");

		
		Departamento departamento = new Departamento(codigo, nome, sigla);
		
		return departamento;			
	}
	
	/**
	 * Remove um departamento no banco de dados
	 * @param codigo PK do departamento
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_SIP_DEPTO WHERE CD_DEPTO = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Departamento não encontrado para ser removido");
		}
	}
	
}//class
