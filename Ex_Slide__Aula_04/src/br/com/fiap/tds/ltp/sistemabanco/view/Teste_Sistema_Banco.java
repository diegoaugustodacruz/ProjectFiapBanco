package br.com.fiap.tds.ltp.sistemabanco.view;

import java.util.Scanner;

import br.com.fiap.tds.ltp.sistemabanco.entidades.Cliente;
import br.com.fiap.tds.ltp.sistemabanco.entidades.ContaCorrente;
import br.com.fiap.tds.ltp.sistemabanco.entidades.Endereco;


public class Teste_Sistema_Banco {
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		Endereco dados1 = new Endereco();
		Cliente dados2 = new Cliente();
		ContaCorrente dados3 = new ContaCorrente();
		
		
		
		System.out.print("Digite o nome da rua: ");
		String rua = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite o numero do imovel: ");
		short numero = leitor.nextShort();
		
		System.out.print("Digite o complemento: ");
		String complemento = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite o bairro: ");
		String bairro = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite o CEP: ");
		String cep = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite o nome: ");
		String nome = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite o CPF: ");
		String cpf = leitor.next() + leitor.nextLine();
		
		System.out.print("Digite o Saldo: ");
		double saldo = leitor.nextDouble();
		
		dados1.rua=rua;
		dados1.numero=numero;
		dados1.complemento=complemento;
		dados1.bairro=bairro;
		dados1.cep=cep;
		
		dados2.nome=nome;
		dados2.cpf=cpf;
		dados2.endereco=dados1;
		
		dados3.saldo=saldo;
		dados3.titular=dados2;
		
		System.out.print("Nome do cliente" + dados3.titular.nome + " Saldo: " + dados3.saldo + " CEP: " + dados3.titular.endereco.cep);
		
		
		System.out.print("Arrume o número: ");
		short numero2 = leitor.nextShort();
		dados1.setNumero(numero2);
		
		double novoSaldo = dados3.retornaSaldo();
		
		
		
		
		
		
		leitor.close();
		
	
		
	}

}
