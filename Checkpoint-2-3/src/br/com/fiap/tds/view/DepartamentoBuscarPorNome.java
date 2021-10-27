package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bo.DepartamentoBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class DepartamentoBuscarPorNome {

	// Pesquisar por nome
		public static void main(String[] args) {

			Connection conexao = null;

			try {
				// Obter a conex�o
				conexao = ConnectionFactory.getConnection();
				// Instanciar o Bo
				DepartamentoBO bo = new DepartamentoBO(conexao);
				// Ler o nome
				String nome = JOptionPane.showInputDialog("Digite o nome");
				// Pesquisar por nome
				List<Departamento> lista = bo.buscarPorNome(nome);
				// Exibir o resultado
				for (Departamento departamento : lista) {
					JOptionPane.showMessageDialog(null, departamento);

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
