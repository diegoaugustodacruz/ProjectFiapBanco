package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bo.FuncionarioBO;
import br.com.fiap.tds.exception.IdNotFoundException;
import br.com.fiap.tds.factory.ConnectionFactory;

public class FuncionarioAtualizar {
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			conexao = ConnectionFactory.getConnection();									
			
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
		
			String nome = (JOptionPane.showInputDialog("Digite o nome do nome: "));
			String cpf = (JOptionPane.showInputDialog("Digite o CPF: "));
			String dataNascimento = JOptionPane.showInputDialog("Digite data de nascimento: ");
			String estadoCivil = JOptionPane.showInputDialog("Digite estado civil: ");
			float salario = Float.parseFloat(JOptionPane.showInputDialog("Digite o salario: "));
			String dataAdmissao = (JOptionPane.showInputDialog("Digite a data de admissao: "));			

			Funcionario funcionario = new Funcionario(codigo, nome, cpf, dataNascimento, estadoCivil, salario, dataAdmissao);
			
			FuncionarioBO bo3 = new FuncionarioBO(conexao);
			bo3.atualizar(funcionario);
			
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
