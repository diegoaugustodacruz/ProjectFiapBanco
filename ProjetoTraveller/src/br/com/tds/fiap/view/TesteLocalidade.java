package br.com.tds.fiap.view;

import javax.swing.JOptionPane;

import br.com.tds.fiap.bean.Localidade;

public class TesteLocalidade {
	
	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Digite o nome da localidade: ");
		
		double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a area da localidade em km²: "));
		
		double habitantes = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de habitantantes da localidade: "));
		
		
		Localidade localidade = new Localidade(nome, area, habitantes);
		
		double densidade = localidade.densidade();
		
		JOptionPane.showMessageDialog(null, localidade);
		
		JOptionPane.showMessageDialog(null, "A densidade da localidade é: " + densidade + " hab/km²");
		
		
		
	}

}
