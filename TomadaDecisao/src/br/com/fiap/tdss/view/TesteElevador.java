package br.com.fiap.tdss.view;

import javax.swing.JOptionPane;

import br.com.fiap.tdss.bean.Elevador;

public class TesteElevador {

	public static void main(String[] args) {

		// Pedir uma opção para o usuário
		// 1 - Subir um andar, exibir o andar atual
		// 2 - Descer um andar, exibir o andar atual
		// 3 - Entrar com x pessoas, exibir a qtd de pessoas no elevador
		// 4 - Sai com x pessoas, exibir a qtd de pessoas no elevador

		int totalAndares = Integer.parseInt(JOptionPane.showInputDialog("Total de andares: "));
		int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Capacidade Elevador: "));

		Elevador elevador = new Elevador(capacidade, totalAndares);

		int acao = 1;

		do {

			acao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção : \n" + "1 - Subir \n"
					+ "2 - Descer um andar \n" + "3 - Entrar \n" + "4 - Sair \n" + "0 - Encerrar"));

			switch (acao) {
			case 1: {
				elevador.sobe();
				JOptionPane.showMessageDialog(null, "Andar Atual: " + elevador.getAndarAtual());
				break;
			}
			case 2: {
				elevador.desce();
				JOptionPane.showMessageDialog(null, "Andar Atual: " + elevador.getAndarAtual());
				break;
			}

			case 3: {
				int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade que entrou: "));
				JOptionPane.showMessageDialog(null, "Pessoas no elevador: " + elevador.entra(qtd));
				break;
			}
			case 4: {
				int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade que entrou: "));
				JOptionPane.showMessageDialog(null, "Pessoas no elevador: " + elevador.sai(qtd));
				break;

			}
			case 0: {
				JOptionPane.showMessageDialog(null, "FIM");
				break;

			}
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");

			}
		} while (acao != 0);

	}

}
