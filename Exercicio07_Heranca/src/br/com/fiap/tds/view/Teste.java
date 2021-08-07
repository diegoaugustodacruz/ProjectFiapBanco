package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.ltp.pacotes.ex2.produtos.livro.LivroInfantil;

public class Teste {
	
	public static void main(String[] args) {
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: "));
		
		int preco = Integer.parseInt(JOptionPane.showInputDialog("Digite o preco do produto: "));

		String autor = JOptionPane.showInputDialog("Digite o autor do livro: ");
		
		String titulo = JOptionPane.showInputDialog("Digite o titulo do livro: ");

		String isbn = JOptionPane.showInputDialog("Digite o isb do livro: ");

		String ilustrador = JOptionPane.showInputDialog("Digite o ilustrador do livro: ");

		
		LivroInfantil dados = new LivroInfantil(codigo, preco, autor, titulo, isbn, ilustrador);
		
		JOptionPane.showMessageDialog(null, "Código: " + dados.getCodigo() + "\nPreco: " + dados.getPreco() + "\nAutor" + dados.getAutor() + "\nTitulo: " + dados.getTitulo() + "\nISNB: " + dados.getIsbn() + "\nIlustrador: " + dados.getIlustrador());
		
		
		
		
		
	}
	

}
