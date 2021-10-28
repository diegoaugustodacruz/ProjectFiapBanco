package br.com.fiap.tds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que realiza operacoes basicas com o funcionario no banco
 * @author Grupo
 *
 */
public class FuncionarioDAO {
	
	private Connection conexao;

	/**
	 * Construtor que recebe a conexao como injecao de dependencia
	 * @param conexao
	 */
	public FuncionarioDAO(Connection conexao) {
		this.conexao = conexao;
		
	}
	
	/**
	 * Pesquisa os funcionarios por parte do nome da funcionario
	 * @param nome Termo de pesquisa
	 * @return List<Funcionario> Lista dos funcionarios encontrados
	 * @throws SQLException
	 */
	public List<Funcionario> buscarPorNome(String nome) throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SIP_FUNCIONARIO WHERE NM_FUNCIONARIO LIKE ?");

		stmt.setString(1,"%" + nome + "%");		
		
		ResultSet result = stmt.executeQuery();
		
		return parseList(result);
	}
	
	/**
	 * Recebe o resultado de uma pesquisa e retora uma lista
	 * @param result Resultado de uma pesquisa
	 * @return List<Funcionario> lista de funcionarios
	 * @throws SQLException
	 */
	private List<Funcionario> parseList(ResultSet result) throws SQLException{
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		while(result.next()) {			
			Funcionario funcionario = parse(result);
			lista.add(funcionario);
		}
		return lista;
		
	}
	
	/**
	 * Cadastra um funcionario no banco de dados
	 * @param endereco Funcionario com valores que serao cadastrados
	 * @throws SQLException
	 */
	public void cadastrar(Funcionario funcionario) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_SIP_FUNCIONARIO "
				+ "(CD_FUNC, CD_DEPTO, NM_FUNCIONARIO, DS_CPF, DT_NASCIMENTO, DS_ESTADO_CIVIL, VL_SALARIO, DT_ADMISSAO)"
				+ " VALUES (SQ_ENDORF_END.NEXTVAL, ?, ?, ?, TO_DATE(?,'DD/MM/YYYY'), ?, ?, TO_DATE(?,'DD/MM/YYYY'))");
		
		stmt.setInt(1, funcionario.getDepartamento().getCodigo());
		stmt.setString(2, funcionario.getNome());
		stmt.setString(3, funcionario.getCpf());
		stmt.setString(4, funcionario.getDataNascimento());
		stmt.setString(5, funcionario.getEstadoCivil());
		stmt.setDouble(6, funcionario.getSalario());
		stmt.setString(7, funcionario.getDataAdmissao());
		
		stmt.executeUpdate();
		
		
	}
	
	/**
	 * Atualiza funcionario no banco de dados
	 * @param funcionario Funcionario com valores que serao atualizados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Funcionario funcionario) throws SQLException, IdNotFoundException{
		pesquisar(funcionario.getCodigo());
		
		PreparedStatement stmt = conexao.prepareStatement("UPDATE T_SIP_FUNCIONARIO SET NM_FUNCIONARIO = ?, DS_CPF = ?, "
				+ "DT_NASCIMENTO = TO_DATE(?,'DD/MM/YYYY'), DS_ESTADO_CIVIL = ?, VL_SALARIO = ?, DT_ADMISSAO = TO_DATE(?,'DD/MM/YYYY') "
				+ "WHERE CD_FUNC = ?");
		
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getCpf());
		stmt.setString(3, funcionario.getDataNascimento());
		stmt.setString(4, funcionario.getEstadoCivil());
		stmt.setDouble(5, funcionario.getSalario());
		stmt.setString(6, funcionario.getDataAdmissao());		
		stmt.setInt(7, funcionario.getCodigo());

		int qtd = stmt.executeUpdate();		

		if(qtd == 0) {
			throw new IdNotFoundException("Funcionario não encontrado");
		}
		
	}
	
	/**
	 * Pesquisa um funcionario no banco de dados pela PK
	 * @param codigo PK do funcionario
	 * @return Funcionario funcionario com valores encontrados
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Funcionario pesquisar(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SIP_FUNCIONARIO WHERE CD_FUNC = ?");
		
		stmt.setInt(1, codigo);		

		ResultSet result = stmt.executeQuery();

		if(!result.next()) {
			throw new IdNotFoundException("Funcionario não encontrado");
			
		}
		
		Funcionario funcionario = parse(result);
		
		return funcionario;
	}
	
	/**
	 * Retorna todos os funcionario do banco de dados
	 * @return List<Funcionario> Lista de funcionarios
	 * @throws SQLException
	 */
	public List<Funcionario> listar() throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_SIP_FUNCIONARIO");
		
		ResultSet result = stmt.executeQuery();

		List<Funcionario> lista = new ArrayList<Funcionario>();

		while(result.next()) {			
			Funcionario funcionario = parse(result);
			lista.add(funcionario);
		}
		return lista;
	}
	
	/**
	 * Recupera as informacoes de um registro do banco e retorna o funcionario
	 * @param result ResultSet o(s) registro(s) encontrados
	 * @return Funcionario funcionario com os valores do banco de dados
	 * @throws SQLException
	 */
	private Funcionario  parse(ResultSet result) throws SQLException {

		int codigo = result.getInt("CD_FUNC");
		String nome = result.getString("NM_FUNCIONARIO");
		String cpf = result.getString("DS_CPF");
		String dataNascimento = result.getString("DT_NASCIMENTO");
		String estadoCivil = result.getString("DS_ESTADO_CIVIL");
		double salario = result.getDouble("VL_SALARIO");
		String dataAdmissao = result.getString("DT_ADMISSAO");

		Funcionario funcionario = new Funcionario(codigo, nome, cpf, dataNascimento, estadoCivil, salario, dataAdmissao);
		
		return funcionario;			
	}
	
	/**
	 * Remove um funcionario no banco de dados
	 * @param codigo PK do funcionario
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_SIP_FUNCIONARIO WHERE CD_FUNC = ?");

		stmt.setInt(1, codigo);	
		
		int qtd = stmt.executeUpdate();

		if(qtd == 0) {
			throw new IdNotFoundException("Funcionario não encontrado para ser removido");
		}
	}
	
	

}//class
