package br.com.fiap.tds.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.dao.SupermercadoDAO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.SupermercadoTO;

/**
 * Classe que realiza operacoes basicas com o supermercado no banco
 * @author Diego
 *
 */
public class SupermercadoOracleDAO implements SupermercadoDAO{
	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public SupermercadoOracleDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os supermercados por parte do nome
	 * @param nome Termo de pesquisa
	 * @return List<Supermercado> Lista dos supermercados encontrados
	 * @throws SQLException
	 */
	@Override
	public List<SupermercadoTO> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SUPERMERCADOS WHERE NM_SUPERMERCADO LIKE ?");

		stmt.setString(1,"%" + nome + "%");		
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);	
		
		
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Supermercado> lista de supermercados
	 * @throws SQLException
	 */
	private List<SupermercadoTO> parseList(ResultSet result) throws SQLException{
		List<SupermercadoTO> lista = new ArrayList<SupermercadoTO>();
		
		while(result.next()) {			
			SupermercadoTO supermercado = parse(result);
			lista.add(supermercado);
		}
		return lista;
		
	}
	
	

	/**
	 * Cadastra um supermercado no banco de dados
	 * @param supermercado Supermrecado com valores que serao cadastrados
	 * @throws SQLException
	 */
	@Override
	public void cadastrar(SupermercadoTO supermercado) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_SUPERMERCADOS "
				+ "(CD_SUPERMERCADO, NM_SUPERMERCADO, ST_ATIVO, DT_CADASTRO, NR_CNPJ, DS_EMAIL, DS_SENHA)"
				+ " VALUES (SQ_T_SUPERMERCADO.NEXTVAL, ?, 'ATIVO', SYSDATE, ?, ?, ?)", new String[] {"CD_SUPERMERCADO"});
		
		stmt.setString(1, supermercado.getNome());
		stmt.setString(2, supermercado.getCnpj());
		stmt.setString(3, supermercado.getEmail());
		stmt.setString(4, supermercado.getSenha());

		
		stmt.executeUpdate();
		
		ResultSet result = stmt.getGeneratedKeys();
		if(result.next()) {
			int codigo = result.getInt(1);
			supermercado.setCodigo(codigo);
		}
	}
	
	/**
	 * Atualiza supermercado no banco de dados
	 * @param supermercado Supermercado com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void atualizar(SupermercadoTO supermercado) throws SQLException, IdNotFoundException{
		pesquisar(supermercado.getCodigo());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE T_SUPERMERCADOS SET NM_SUPERMERCADO = ?,"
				+ " NR_CNPJ = ?, DS_EMAIL = ?, DS_SENHA = ? WHERE CD_SUPERMERCADO = ?");
		stmt.setString(1, supermercado.getNome());
		stmt.setString(2, supermercado.getCnpj());
		stmt.setString(3, supermercado.getEmail());
		stmt.setString(4, supermercado.getSenha());		
		stmt.setInt(5, supermercado.getCodigo());

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Supermercado não encontrado");
		}

		
	}
	
	/**
	 * Pesquisa um Supermercado no banco de dados pela PK
	 * @param codigo PK do Supermercado
	 * @return Supermercado supermercado com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public SupermercadoTO pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SUPERMERCADOS WHERE CD_SUPERMERCADO = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Supermercado não encontrado");
			
		}
		
		SupermercadoTO supermercado = parse(result);
		
		return supermercado;
	}
	
	/**
	 * Retorna todos os supermercado do banco de dados
	 * @return List<Supermercado> Lista de supermercado
	 * @throws SQLException
	 */
	@Override
	public List<SupermercadoTO> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SUPERMERCADOS");
		
		ResultSet result = stmt.executeQuery();

		List<SupermercadoTO> lista = new ArrayList<SupermercadoTO>();

		while(result.next()) {			
			SupermercadoTO supermercado = parse(result);
			lista.add(supermercado);
		}
		return lista;
	}

	/**
	 * Recupera as informacoes de um registro do banco e retorna o supermercado
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Supermercado supermercado com os valores do banco de dados
	 * @throws SQLException
	 */
	private SupermercadoTO parse(ResultSet result) throws SQLException {

		int codigo = result.getInt("CD_SUPERMERCADO");
		String nome = result.getString("NM_SUPERMERCADO");
		String ativo = result.getString("ST_ATIVO");
		String dataCadastro = result.getString("DT_CADASTRO");
		String cnpj = result.getString("NR_CNPJ");
		String email = result.getString("DS_EMAIL");
		String senha = result.getString("DS_SENHA");
		
		SupermercadoTO supermercado = new SupermercadoTO(codigo, nome, ativo, dataCadastro, cnpj, email, senha);
		
		return supermercado;			
	}
	
	/**
	 * Remove um supermercado no banco de dados
	 * @param codigo PK do supermercado
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@Override
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_SUPERMERCADOS WHERE CD_SUPERMERCADO = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Supermercado não encontrado para ser removido");
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		conexao.close();
	}
	
}
