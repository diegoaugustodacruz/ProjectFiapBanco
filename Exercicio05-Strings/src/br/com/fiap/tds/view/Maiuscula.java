package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

public class Maiuscula {
	public static void main(String[] args) {
		
	String palavra = JOptionPane.showInputDialog("Digite uma palavra: ");
	
	JOptionPane.showMessageDialog(null, palavra.toUpperCase());
		
		
	}

}
