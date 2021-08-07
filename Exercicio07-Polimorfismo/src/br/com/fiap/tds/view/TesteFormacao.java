package br.com.fiap.tds.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Bacharelado;
import br.com.fiap.tds.bean.Formacao;
import br.com.fiap.tds.bean.Medio;
import br.com.fiap.tds.bean.Tecnologo;

public class TesteFormacao {
	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		
		System.out.println("Escolha a opção: \n1 - Medio \n2 - Tecnologo \n3 - Bacharelado");
		int op = leitor.nextInt();		
		
		System.out.println("Digite a descricao: ");
		String descricao = leitor.next() + leitor.nextLine();
		
		System.out.println("Digite o periodo: ");
		int periodo = leitor.nextInt();
		
		switch(op) {
			case 1:{
				System.out.println("Digite o tipo: ");
				String tipo = leitor.next() + leitor.nextLine();
				Medio medio = new Medio(descricao, periodo, tipo);
				medio.definirDuracao();
				medio.calcularMensalidade(1);
				System.out.println(medio);
				break;
		}
			case 2:{
				System.out.println("É plano estendido: ");
				boolean plano = leitor.nextBoolean();
				Tecnologo tecnologo = new Tecnologo(descricao, periodo, plano);
				tecnologo.definirDuracao();
				tecnologo.calcularMensalidade(1);
				System.out.println(tecnologo);				
				break;	
			}
			case 3: {
				System.out.println("Digite o TCC: ");
				String tcc = leitor.next() + leitor.nextLine();
				System.out.println("Digite a carga horaria do estagio: ");
				int carga = leitor.nextInt();
				Bacharelado bacharel = new Bacharelado(descricao, periodo, tcc, carga);
				bacharel.definirDuracao();
				bacharel.calcularMensalidade(1);
				break;
			}
			default:
				System.out.println("Opção invalida");
		
		}

		
		
		
		
		
	}

}
