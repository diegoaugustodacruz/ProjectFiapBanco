package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bo.FuncionarioBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class FuncionarioPesquisar {

	public static void main(String[] args) {
		
		Connection conexao = null;
		try {
			//Obter uma conex�o
			conexao = ConnectionFactory.getConnection();
			
			//Instanciar o DAO
			FuncionarioBO bo = new FuncionarioBO(conexao);
			
			//Ler o c�digo
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));
			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Digite o c�digo");
//			int codigo = sc.nextInt();
			
			//Pesquisar
			Funcionario funcionario = bo.pesquisar(codigo);
			
			//Exibir os dados do produto
			JOptionPane.showMessageDialog(null, funcionario);

//			System.out.println(departamento);
			
			
		} catch (IdNotFoundException e1) {
			System.err.println(e1.getMessage());
		}catch (Exception e) {
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
