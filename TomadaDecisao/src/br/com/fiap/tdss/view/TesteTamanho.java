package br.com.fiap.tdss.view;

import javax.swing.JOptionPane;

public class TesteTamanho {
	public static void main(String[] args) {
		
		
		String nome1 = JOptionPane.showInputDialog("Digite o nome da 1ª pessoa");
		float altura1 = Float.parseFloat(JOptionPane.showInputDialog("Digite a altura da 1ª pessoa"));
		float peso1 = Float.parseFloat(JOptionPane.showInputDialog("Digite o peso da 1ª pessoa"));
		
		String nome2 = JOptionPane.showInputDialog("Digite o nome da 2ª pessoa");
		float altura2 = Float.parseFloat(JOptionPane.showInputDialog("Digite a altura da 2ª pessoa"));
		float peso2 = Float.parseFloat(JOptionPane.showInputDialog("Digite o peso da 2ª pessoa"));
		
		
		if(peso1>peso2) {
			JOptionPane.showMessageDialog(null, "O nome da mais pesada é " + nome1);
			
		}
		else if (peso2>peso1){
			JOptionPane.showMessageDialog(null, "O nome da mais pesada é " + nome2);

		}
		else {
			JOptionPane.showMessageDialog(null, "Possuem o mesmo peso");

		}
		
		if(altura1>altura2) {
			JOptionPane.showMessageDialog(null, "O nome da mais alta é " + nome1);
			
		}
		else if (altura2>altura1) {
			JOptionPane.showMessageDialog(null, "O nome da mais alta é " + nome2);

		}
		else {
			JOptionPane.showMessageDialog(null, "Possuem a mesma altura");

		}
		
	}
	
	
	

}
