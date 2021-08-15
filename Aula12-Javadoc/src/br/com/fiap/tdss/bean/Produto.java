package br.com.fiap.tdss.bean;

/**
 * Classe representa o produto da loja
 * @author diego
 *@version 1.0
 *
 *
 *
 *
 */
public class Produto {
	/**
	 * titulo do produto
	 */
	private String titulo;
	
	/**
	 * Preço do produto
	 */
	
	private double preco;
	
	/**
	 * Categoria do produto
	 */
	private String categoria;

	/**
	 * Inicializa o objeto com valores padrão
	 */
	public Produto () {
		
	}
	
	/**
	 * 
	 * @param titulo titulo do produto
	 * @param preco preço do produto
	 * @param categoria categoria do produto
	 */
	public Produto(String titulo, double preco, String categoria) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	/**
	 * Retorna o titulo do produto
	 * @return titulo do produto
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Altera o titulo do produto
	 * @param titulo titulo do produto
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Retorna o preco do produto
	 * @return titulo do produto
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * Altera o preco do produto
	 * @param preco preco do produto
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/**
	 * Retorna a categoria do produto
	 * @return categoria do produto
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * Altera o categoria do produto
	 * @param categoria categoria do produto
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Calcula o preço final do produto com a porcentagem de desconto aplicada
	 * @param porcentagem porcentagem de desconto. Ex: 20, 30
	 * @return valor do produto com o desconto
	 */
	public double calcularDesconto(double porcentagem) {
		return preco - preco*(porcentagem/100);
		
	}
	/**
	 * Calcula o preco final do produto com a porcentagem de inflacao aplicada
	 * @param inflacao porcentagem de inflacao aplicada
	 */
	public void aumentarPreco(double inflacao) {
		preco = preco + preco*inflacao/100;
		
		
	}
	
}
