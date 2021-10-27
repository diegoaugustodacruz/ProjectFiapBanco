package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bo.DepartamentoBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class DepartamentoListar {

	//Listar
		public static void main(String[] args) {
			
			Connection conexao = null;
			
			try {
				//Obter uma conex�o
				conexao = ConnectionFactory.getConnection();
				
				//Instanciar o Dao
				DepartamentoBO bo = new DepartamentoBO(conexao);
				
				//Pesquisar todos os produtos
				List<Departamento> lista = bo.listar();
				
				//Exibir os produtos
				for (Departamento departamento : lista) {
					System.out.println(departamento);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conexao != null) conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}//main
}
