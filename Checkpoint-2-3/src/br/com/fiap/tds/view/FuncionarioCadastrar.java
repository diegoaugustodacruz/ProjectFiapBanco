package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bo.FuncionarioBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class FuncionarioCadastrar {
	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			Departamento departamento = new Departamento();
			
			departamento.setNome(JOptionPane.showInputDialog("Digite o nome do departamento: "));
			
			departamento.setSigla(JOptionPane.showInputDialog("Digite a sigla do departamento: "));			
			
			conexao = ConnectionFactory.getConnection();			
			
			String nome = (JOptionPane.showInputDialog("Digite o nome do nome: "));
			String cpf = (JOptionPane.showInputDialog("Digite o CPF: "));
			String dataNascimento = JOptionPane.showInputDialog("Digite data de nascimento: ");
			String estadoCivil = JOptionPane.showInputDialog("Digite estado civil: ");
			float salario = Float.parseFloat(JOptionPane.showInputDialog("Digite o salario: "));
			String dataAdmissao = (JOptionPane.showInputDialog("Digite a data de admissao: "));			
			
			Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, estadoCivil, salario, dataAdmissao, departamento);
			
			FuncionarioBO bo = new FuncionarioBO(conexao);
			
			bo.cadastrar(funcionario);
			System.out.println("Sucesso!");
			
		} catch (Exception e) {
			try {
				if (conexao != null) conexao.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}//main
}
