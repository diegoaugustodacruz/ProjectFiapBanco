package br.com.fiap.tds.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.fiap.tds.bean.ContaCorrente;
import br.com.fiap.tds.exception.SaldoInsuficienteException;
import br.com.fiap.tds.exception.ValorNegativoException;

public class TesteContaCorrente {
	
	private static Scanner leitor = new Scanner(System.in);

	// Criar um método para ler um numero e tratar a excemption, caso o usuario nao
	// digite um numero
	// static -> permite que o elemento seja utilizado sem um objeto, pois o
	// elemento passa a ser de classe e nao do objeto
	private static double lerDouble() {
		while (true) {
			try {
				double valor = leitor.nextDouble();
				leitor.close();
				return valor;
			} catch (InputMismatchException e) {
				System.out.println("Numero invalido");
				leitor.next();
				
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Digite o saldo");
		double saldo = lerDouble();

		System.out.println("Digite o limite");
		double limite = lerDouble();

		try {
			ContaCorrente cc = new ContaCorrente(saldo, limite);

			int opcao;
			do {
				System.out.println("1-Sacar \n2-Depositar \n3-Alterar Limite \n0-Sair");
				opcao = (int) lerDouble();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor do saque: ");
					double saque = lerDouble();
					try {
						cc.sacar(saque);
						System.out.println("Saque realizado! Novo saldo: " + cc.getSaldo());
					} catch (ValorNegativoException | SaldoInsuficienteException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 2:
					System.out.println("Digite o valor do deposito: ");
					double deposito = lerDouble();
					try {
						cc.depositar(deposito);
						System.out.println("Deposito realizado! Novo saldo: " + cc.getSaldo());

					} catch (ValorNegativoException e) {
						System.out.println(e.getMessage());

					}
					break;

				case 3:
					System.out.println("Digite o valor do novo limite: ");
					double novoLimite = lerDouble();
					try {
						cc.setLimite(novoLimite);
						System.out.println("Novo limite configurado: " + cc.getLimite());

					} catch (ValorNegativoException e) {
						System.out.println(e.getMessage());

					}
					break;
				case 0:
					System.out.println("Finalizando o sistema...");
					break;

				default:
					System.out.println("Opcao errada. Digite novamente");
					break;

				}

				System.out.println(cc);

			} while (opcao != 0);

		} catch (ValorNegativoException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		leitor.close();
	}
}
