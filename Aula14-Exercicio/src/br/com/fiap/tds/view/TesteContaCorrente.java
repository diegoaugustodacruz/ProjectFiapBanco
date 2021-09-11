package br.com.fiap.tds.view;

import java.util.Scanner;

import br.com.fiap.tds.bean.ContaCorrente;
import br.com.fiap.tds.exception.SaldoInsuficienteException;
import br.com.fiap.tds.exception.ValorNegativoException;

public class TesteContaCorrente {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o saldo");
		double saldo = leitor.nextDouble();
		
		System.out.println("Digite o limite");
		double limite = leitor.nextDouble();
								
		try {
			ContaCorrente cc = new ContaCorrente(saldo, limite);
			
			int opcao;
			do {
				System.out.println("1-Sacar \n2-Depositar \n3-Alterar Limite \n0-Sair");
				opcao = leitor.nextInt();
				
				switch (opcao) {
					case 1:
						System.out.println("Digite o valor do saque: ");
						double saque = leitor.nextDouble();
						try {
							cc.sacar(saque);
							System.out.println("Saque realizado! Novo saldo: " + cc.getSaldo());
						}catch(ValorNegativoException | SaldoInsuficienteException e) {
							System.out.println(e.getMessage());
						}
						break;
						
					case 2:
						System.out.println("Digite o valor do deposito: ");
						double deposito = leitor.nextDouble();
						try {
							cc.depositar(deposito);
							System.out.println("Deposito realizado! Novo saldo: " + cc.getSaldo());


						}catch(ValorNegativoException e) {
							System.out.println(e.getMessage());

						}
						break;
					
					case 3:
						System.out.println("Digite o valor do novo limite: ");
						double novoLimite = leitor.nextDouble();
						try {
							cc.setLimite(novoLimite);
							System.out.println("Novo limite configurado: " + cc.getLimite());

						}catch(ValorNegativoException e) {
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
				
			}while(opcao != 0);	
			
			
			
		}catch(ValorNegativoException e) {
			System.out.println(e.getMessage());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		

	}
	

}
