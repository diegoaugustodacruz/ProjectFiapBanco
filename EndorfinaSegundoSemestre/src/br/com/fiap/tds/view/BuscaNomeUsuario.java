package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.bo.UsuarioBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class BuscaNomeUsuario {
	public static void main(String[] args) {

		Connection conexao = null;

		try {
			// Obter a conex�o
			conexao = ConnectionFactory.getConnection();
			// Instanciar o Bo
			UsuarioBO bo = new UsuarioBO(conexao);
			// Ler o nome
			String nome = JOptionPane.showInputDialog("Digite o nome");
			// Pesquisar por nome
			List<Usuario> lista = bo.buscarPorNome(nome);
			// Exibir o resultado
			for (Usuario usuario: lista) {
				System.out.println(usuario);
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
