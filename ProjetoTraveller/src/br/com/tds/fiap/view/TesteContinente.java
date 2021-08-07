package br.com.tds.fiap.view;

import javax.swing.JOptionPane;

import br.com.tds.fiap.bean.Continente;

public class TesteContinente {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Digite o nome do continente: ");
		
		double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a area do continente em km²: "));
		
		double habitantes = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de habitantantes do continente: "));
		
		String hemisferio = JOptionPane.showInputDialog("Digite o hemisferio do continente: ");

		String lesteOeste = JOptionPane.showInputDialog("Digite se o continente esta no leste ou oeste: ");
		
		String climaPredominanteContinente = JOptionPane.showInputDialog("Digite o clima predominante do continente: ");


		Continente continente = new Continente(nome, area, habitantes, hemisferio, lesteOeste, climaPredominanteContinente);
		
		
		JOptionPane.showMessageDialog(null, continente);
		
		
		
	}
	
	
}
