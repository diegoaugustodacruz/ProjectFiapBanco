package br.com.fiap.tds.ltp.pacotes.ex2.produtos.livro;

public class LivroInfantil extends Livro{
	
	private String ilustrador;
	
	public LivroInfantil() {
		
	}
	
	public LivroInfantil(int codigo, int preco, String autor, String titulo, String isbn, String ilustrador) {
		super(codigo, preco, autor, titulo, isbn);
		this.ilustrador = ilustrador;
	}

	public String getIlustrador() {
		return ilustrador;
	}

	public void setIlustrador(String ilustrador) {
		this.ilustrador = ilustrador;
	}
	
	
	
	
	
}
