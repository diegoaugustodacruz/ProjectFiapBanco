package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bo.DepartamentoBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class DepartamentoPesquisar {

	//Pesquisar por c�digo
		public static void main(String[] args) {
			
			Connection conexao = null;
			try {
				//Obter uma conex�o
				conexao = ConnectionFactory.getConnection();
				
				//Instanciar o DAO
				DepartamentoBO bo = new DepartamentoBO(conexao);
				
				//Ler o c�digo
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));
				
//				Scanner sc = new Scanner(System.in);
//				System.out.println("Digite o c�digo");
//				int codigo = sc.nextInt();
				
				//Pesquisar
				Departamento departamento = bo.pesquisar(codigo);
				
				//Exibir os dados do produto
				JOptionPane.showMessageDialog(null, departamento);

//				System.out.println(departamento);
				
				
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
