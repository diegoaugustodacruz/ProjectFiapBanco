package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bo.DepartamentoBO;
import br.com.fiap.tds.bo.FuncionarioBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class DepartamentoBuscarPorNome {

	// Pesquisar por nome
		public static void main(String[] args) {

			Connection conexao = null;

			try {
				conexao = ConnectionFactory.getConnection();
				
				FuncionarioBO bo2 = new FuncionarioBO(conexao);
				
				String nome2 = JOptionPane.showInputDialog("Digite o nome");
				
				List<Funcionario> lista = bo2.buscarPorNome(nome2);
				
				for (Funcionario funcionario2 : lista) {

					JOptionPane.showMessageDialog(null, funcionario2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conexao != null)
						conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}// main
}
