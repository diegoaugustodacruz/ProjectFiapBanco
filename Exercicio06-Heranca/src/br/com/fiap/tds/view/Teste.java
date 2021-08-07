package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Carro;
import br.com.fiap.tds.bean.Cor;

public class Teste {
	
	public static void main(String[] args) {
		
		
		
		
		String modelo = JOptionPane.showInputDialog("Digite o modelo do carro: ");

		int quantidadeLugares = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de lugares: "));

		int comprimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o comprimento: "));

		int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricacao: "));

		Cor cor = new Cor(1, 2, 3);

		
		int quantidadePortas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de portas do carro: "));


		String placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
		
		float motor = Long.parseLong(JOptionPane.showInputDialog("Digite o motor: "));
		
		
		Carro carro = new Carro(modelo, quantidadeLugares, comprimento, anoFabricacao, cor, quantidadePortas, placa, motor);
		
		
		JOptionPane.showMessageDialog(null, carro);
		
	}

}
