package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bo.DepartamentoBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class DepartamentoAtualizar {
	
	//Exemplo de atualiza��o
		public static void main(String[] args) {
			
			Connection conexao = null;
			
			try {
				conexao = ConnectionFactory.getConnection();			
			
				Scanner sc = new Scanner(System.in);
				
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
//				System.out.println("Digite o c�digo");
//				int codigo = sc.nextInt();
				
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
//				System.out.println("Digite o nome");
//				String nome = sc.next() + sc.nextLine();
				
				String sigla = JOptionPane.showInputDialog("Digite a sigla: ");
//				System.out.println("Digite a sigla");
//				String sigla = sc.next() + sc.nextLine();				
				
				//Instanciar o produto com os dados
				Departamento departamento = new Departamento(codigo, nome, sigla);
				
				//Atualizar
				DepartamentoBO bo = new DepartamentoBO(conexao);
				bo.atualizar(departamento);
				
				System.out.println("Departamento atualizado!");
			
				sc.close();
			} catch (IdNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conexao != null) conexao.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}//main

}
