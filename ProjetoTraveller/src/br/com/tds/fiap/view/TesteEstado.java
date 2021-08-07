package br.com.tds.fiap.view;

import javax.swing.JOptionPane;

import br.com.tds.fiap.bean.Estado;

public class TesteEstado {
	
	public static void main(String[] args) {
		
				
		//Pais		
		String nome = JOptionPane.showInputDialog("Digite o nome do estado: ");
				
		double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a area do estado em km²: "));
				
		double habitantes = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de habitantantes do estado: "));
				
		String capitalEstado = JOptionPane.showInputDialog("Digite as cores da bandeira do estado: ");
				
		String siglaEstado = JOptionPane.showInputDialog("Digite a sigla do estado");				
				
		
		Estado estado = new Estado(nome, area, habitantes, siglaEstado, capitalEstado);
		
		JOptionPane.showMessageDialog(null, estado);
		
		

		
		
		
	}
		
	

}
