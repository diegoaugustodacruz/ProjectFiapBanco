package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bo.DepartamentoBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class DepartamentoRemover {
	
	//Remo��o
		public static void main(String[] args) {
			
			Connection conexao = null;
			
			try {
				conexao = ConnectionFactory.getConnection();
				
				DepartamentoBO bo = new DepartamentoBO(conexao);
				
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));
//				Scanner sc = new Scanner(System.in);
//				System.out.println("Digite o c�digo");
//				int codigo = sc.nextInt();
				
				//Remover o produto
				bo.remover(codigo);
				System.out.println("Produto removido!");
				
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
