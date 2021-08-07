package br.com.empresa.cadastro.view;

import javax.swing.JOptionPane;

import br.com.empresa.cadastro.entidades.Cliente;

public class TesteCliente {
	
	public static void main(String[] args) {
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));
		String nome = JOptionPane.showInputDialog("Digite o nome: ");
		String titulo = JOptionPane.showInputDialog("Digite o titulo: ");
		
		Cliente cliente = new Cliente(codigo, nome, titulo);
		
		cliente.exibirNomeFormatado();
		
	}
	
	
	
	

}
