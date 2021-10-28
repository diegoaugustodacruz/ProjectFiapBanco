package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bo.FuncionarioBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class FuncionarioBuscarPorNome {

	// Pesquisar por nome
			public static void main(String[] args) {

				Connection conexao = null;

				try {
					// Obter a conex�o
					conexao = ConnectionFactory.getConnection();
					// Instanciar o Bo
					FuncionarioBO bo = new FuncionarioBO(conexao);
					// Ler o nome
					String nome = JOptionPane.showInputDialog("Digite o nome");
					// Pesquisar por nome
					List<Funcionario> lista = bo.buscarPorNome(nome);
					// Exibir o resultado
					for (Funcionario funcionario: lista) {
						JOptionPane.showMessageDialog(null, funcionario);

						//System.out.println(departamento);
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
