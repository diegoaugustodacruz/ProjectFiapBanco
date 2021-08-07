package br.com.fiap.exercicio03.teste;

import javax.swing.JOptionPane;

import br.com.fiap.exercicio03.bean.ContaCorrente;
import br.com.fiap.exercicio03.bean.ContaPoupanca;
import br.com.fiap.exercicio03.bean.Titular;

public class Teste {
	
	public static void main(String[] args) {
		
		//Titular
		String nome = JOptionPane.showInputDialog("Digite o nome do titular: ");
		String cpf = JOptionPane.showInputDialog("Digite o cpf do titular: ");
		
		Titular titular = new Titular(nome, cpf);
		
		
		//Poupanca
		double saldopp = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da poupança: "));
		
		int agenciapp = Integer.parseInt(JOptionPane.showInputDialog("Digite a agencia da poupanca: "));
		
		String numeroContapp = JOptionPane.showInputDialog("Digite o numero da conta da poupanca: ");

		double taxaJuros = Double.parseDouble(JOptionPane.showInputDialog("Digite a taxa de juros: "));

		ContaPoupanca contaPoupanca = new ContaPoupanca(saldopp, titular, agenciapp,  numeroContapp,  taxaJuros);
		
		
		
		// Conta Corrente
		double saldocc = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta corrente: "));
		
		int agenciacc = Integer.parseInt(JOptionPane.showInputDialog("Digite a agencia da conta corrente: "));
		
		String numeroContacc = JOptionPane.showInputDialog("Digite o numero da conta da conta corrente: ");

		double limiteCredito = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite de credito: "));

						
		ContaCorrente contaCorrente = new ContaCorrente(saldocc,  titular,  agenciacc,  numeroContacc, limiteCredito);
		
		JOptionPane.showMessageDialog(null, "POUPANCA" + contaPoupanca);
		JOptionPane.showMessageDialog(null, "CONTA CORRENTE" + contaCorrente);
		
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o saque: "));
		
		contaCorrente.sacar(valor);
		contaPoupanca.sacar(valor);
		
		JOptionPane.showMessageDialog(null, "POUPANCA" + contaPoupanca);
		JOptionPane.showMessageDialog(null, "CONTA CORRENTE" + contaCorrente);

		contaCorrente.depositar(valor);
		contaPoupanca.depositar(valor);
		
		JOptionPane.showMessageDialog(null, "POUPANCA" + contaPoupanca);
		JOptionPane.showMessageDialog(null, "CONTA CORRENTE" + contaCorrente);


		
		
	}

}
