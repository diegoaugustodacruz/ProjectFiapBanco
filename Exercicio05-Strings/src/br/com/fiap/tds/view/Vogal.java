package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

public class Vogal {

	public static void main(String[] args) {
	
		String palavra = JOptionPane.showInputDialog("Digite uma palavra: ");
		
		JOptionPane.showMessageDialog(null, palavra.replace("a", "*").replace("e", "*").replace("i", "*").replace("o", "*").replace("u", "*"));
		
		
	}
	
}
