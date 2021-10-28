package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bo.FuncionarioBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class FuncionarioRemover {
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			conexao = ConnectionFactory.getConnection();
			
			FuncionarioBO bo = new FuncionarioBO(conexao);
			
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Digite o c�digo");
//			int codigo = sc.nextInt();
			
			//Remover o produto
			bo.remover(codigo);
			
		} catch (IdNotFoundException e) {
			System.err.println(e.getMessage());
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
