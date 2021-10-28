package br.com.fiap.tds.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Departamento;
import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bo.DepartamentoBO;
import br.com.fiap.tds.bo.FuncionarioBO;
import br.com.fiap.tds.factory.ConnectionFactory;

public class View {
	
public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			
			int opcao;
			do {
				opcao = Integer.parseInt(JOptionPane.showInputDialog("1-Interagir com opções do Departamento \n 2-Interagir com opções do Funcionário"));

				switch (opcao) {
					case 1:
						int opcao2;
						do {
							opcao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro, 2-Buscar por nome, 3-Atualizar, 4-Pesquisar, 5-Listar, 6-Remover"));
							switch (opcao2) {
								case 1:
									Departamento departamento = new Departamento();
									
									departamento.setNome(JOptionPane.showInputDialog("Digite o nome do departamento: "));
									
									departamento.setSigla(JOptionPane.showInputDialog("Digite a sigla do departamento: "));			
									
									conexao = ConnectionFactory.getConnection();
									
									DepartamentoBO bo = new DepartamentoBO(conexao);
									
									bo.cadastrar(departamento);
									
									JOptionPane.showMessageDialog(null, "Departamento Registado");
									break;
								
								case 2:
									conexao = ConnectionFactory.getConnection();
									
									DepartamentoBO bo2 = new DepartamentoBO(conexao);
									
									String nome = JOptionPane.showInputDialog("Digite o nome");
									
									List<Departamento> lista = bo2.buscarPorNome(nome);
									
									for (Departamento departamento2 : lista) {
//										System.out.println(departamento2);

										JOptionPane.showMessageDialog(null, departamento2);
									}
									break;
								
								case 3:
									conexao = ConnectionFactory.getConnection();									
									
									int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
								
									String nome3 = JOptionPane.showInputDialog("Digite o nome: ");
								
									String sigla = JOptionPane.showInputDialog("Digite a sigla: ");
							
									Departamento departamento3 = new Departamento(codigo, nome3, sigla);
									
									DepartamentoBO bo3 = new DepartamentoBO(conexao);
									bo3.atualizar(departamento3);
									break;
									
								case 4:
									conexao = ConnectionFactory.getConnection();
									
									DepartamentoBO bo4 = new DepartamentoBO(conexao);
									
									int codigo4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));									
									
									Departamento departamento4 = bo4.pesquisar(codigo4);
									
									JOptionPane.showMessageDialog(null, departamento4);
									
									break;
	
								case 5:
									conexao = ConnectionFactory.getConnection();
									
									DepartamentoBO bo5 = new DepartamentoBO(conexao);
									
									List<Departamento> lista5 = bo5.listar();
									
									for (Departamento departamento5 : lista5) {
										JOptionPane.showMessageDialog(null, departamento5);

									}
									break;
									
								case 6:
									conexao = ConnectionFactory.getConnection();
									
									DepartamentoBO bo6 = new DepartamentoBO(conexao);
									
									int codigo6 = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));
	
									bo6.remover(codigo6);
									
									break;
									
								default:
									JOptionPane.showMessageDialog(null, "Opcao errada. Digite novamente.");

									break;
							}
						}while(JOptionPane.showConfirmDialog(null, "Quer continuar em Departamento?") == JOptionPane.YES_OPTION);
						break;

					case 2:
						int opcao3;
						do {
							opcao3 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro, 2-Buscar por nome, 3-Atualizar, 4-Pesquisar, 5-Listar, 6-Remover"));
							switch (opcao3) {
								case 1:
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
									break;
								
								case 2:
									conexao = ConnectionFactory.getConnection();
									
									FuncionarioBO bo2 = new FuncionarioBO(conexao);
									
									String nome2 = JOptionPane.showInputDialog("Digite o nome");
									
									List<Funcionario> lista = bo2.buscarPorNome(nome2);
									
									for (Funcionario funcionario2 : lista) {

										JOptionPane.showMessageDialog(null, funcionario2);
									}
									break;
								
								case 3:
									conexao = ConnectionFactory.getConnection();									
									
									int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
								
									String nome3 = (JOptionPane.showInputDialog("Digite o nome do nome: "));
									String cpf3 = (JOptionPane.showInputDialog("Digite o CPF: "));
									String dataNascimento3 = JOptionPane.showInputDialog("Digite data de nascimento: ");
									String estadoCivil3 = JOptionPane.showInputDialog("Digite estado civil: ");
									float salario3 = Float.parseFloat(JOptionPane.showInputDialog("Digite o salario: "));
									String dataAdmissao3 = (JOptionPane.showInputDialog("Digite a data de admissao: "));			

									Funcionario funcionario3 = new Funcionario(codigo, nome3, cpf3, dataNascimento3, estadoCivil3, salario3, dataAdmissao3);
									
									FuncionarioBO bo3 = new FuncionarioBO(conexao);
									bo3.atualizar(funcionario3);
									
									break;
									
								case 4:
									conexao = ConnectionFactory.getConnection();
									
									FuncionarioBO bo4 = new FuncionarioBO(conexao);
									
									int codigo4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));
									
									Funcionario funcionario4 = bo4.pesquisar(codigo4);
									
									JOptionPane.showMessageDialog(null, funcionario4);

									
									break;
	
								case 5:
									
									conexao = ConnectionFactory.getConnection();
									
									FuncionarioBO bo5 = new FuncionarioBO(conexao);
									
									List<Funcionario> lista5 = bo5.listar();
									
									for (Funcionario funcionario5: lista5) {
										JOptionPane.showMessageDialog(null, funcionario5);

									}
									
									break;
									
								case 6:
									conexao = ConnectionFactory.getConnection();
									
									FuncionarioBO bo6 = new FuncionarioBO(conexao);
									
									int codigo6 = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));

									bo6.remover(codigo6);
									
									break;
									
								default:
									JOptionPane.showMessageDialog(null, "Opcao errada. Digite novamente.");

									break;
							}
						}while(JOptionPane.showConfirmDialog(null, "Quer continuar em Funcionario?") == JOptionPane.YES_OPTION);
						break;

				

					default:
						JOptionPane.showMessageDialog(null, "Opcao errada. Digite novamente.");

						break;

				}


			} while(JOptionPane.showConfirmDialog(null, "Quer continuar em outra opção?") == JOptionPane.YES_OPTION);
		
		
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
	}//main

}
