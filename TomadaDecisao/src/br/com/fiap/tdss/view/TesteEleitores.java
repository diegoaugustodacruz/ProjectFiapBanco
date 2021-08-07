package br.com.fiap.tdss.view;

import javax.swing.JOptionPane;

public class TesteEleitores {
	
	public static void main(String[] args) {
		
		
		int i = 0;
		int qtd = 0;

		while(i<3) {
			
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da pessoa"));

		
			if(idade<16) {
				JOptionPane.showMessageDialog(null, "Eleitor: Não Eleitor");
							
			}
			else if(idade>=18 && idade<65) {
				JOptionPane.showMessageDialog(null, "Eleitor: Eleitor Obrigatório");
				qtd = qtd + 1;
			}
			
			else  {
				JOptionPane.showMessageDialog(null, "Eleitor: Eleitor Facultativo");
			}
			
			i = i + 1;
		
		}
		
		JOptionPane.showMessageDialog(null, "Eleitores obrigatórios: " + qtd);

		
	}

}
