package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

public class VogalComLaco {
	
	public static void main(String[] args) {
		
	
		String palavra = JOptionPane.showInputDialog("Digite uma palavra: ");
	
		String vogais = "aeiou";
		
		for(int i = 0; i<vogais.length(); i++) {
			palavra = palavra.replace( vogais.charAt(i) , '*');		
			
			}
		
		
	
		JOptionPane.showMessageDialog(null, palavra);

	}
	




}
