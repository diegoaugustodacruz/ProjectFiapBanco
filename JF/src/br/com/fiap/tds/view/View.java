package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Forca;

public class View {
	
	public static void main(String[] args) {

		Forca forca = new Forca();
		String palavra = "helicoptero";
		String chute = JOptionPane.showInputDialog("Digite uma letra:");

		// for (int i = 0; i < palavra.length(); i++ ) {
		// palavra = palavra.replace(palavra.charAt(i), '*');
		// }
		//
		// while (forca.getVidas() < 6 ) {
		//
		//
		//
		//
		// }

		for (int i = 0; i < palavra.length(); i++ ) {
		System.out.print(palavra.charAt(i));
		}

		}

	
	
}
