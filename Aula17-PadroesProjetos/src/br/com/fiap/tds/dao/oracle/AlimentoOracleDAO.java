package br.com.fiap.tds.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.dao.AlimentoDAO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.to.AlimentoTO;

/**
 * Classe que implementa a interface AlimentoDAO
 * @author diego
 *
 */
public class AlimentoOracleDAO implements AlimentoDAO{
	private Connection conexao;
	
	public AlimentoOracleDAO(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void cadastrar(AlimentoTO alimento) throws SQLException{
		//Criar a query
		PreparedStatement stmt = conexao.prepareStatement("INSERT INTO TB_ALIMENTO (CD_ALIMENTO, NM_ALIMENTO, VL_PESO) VALUES (SQ_TB_ALIMENTO.NEXTVAL, ?, ?)");
	
		//Setar os valores
		stmt.setString(1, alimento.getNome());
		stmt.setDouble(2, alimento.getPeso());
		//Executar a query
		stmt.executeUpdate();

	}

	@Override
	public void atualizar(AlimentoTO alimento) throws IdNotFoundException, SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AlimentoTO alimento) throws IdNotFoundException, SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public AlimentoTO buscar(int codigo) throws IdNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlimentoTO> listar() throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}
	
	//Metodo chamado automaticamente pelo java quando o objeto é finalizado, destruido
	@Override
	protected void finalize() throws Throwable{
		conexao.close();
	}
}
