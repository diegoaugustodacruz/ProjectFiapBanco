package br.com.fiap.tds.bean;

/**
 * Essa classe representa o Produto
 * @author Diego Cruz, Emily Manfrin, Giovana Furlan
 *
 */
public class Produto {
	/**
	 * Número do código do produto
	 */
	private int codigo;
	
	/**
	 * Nome do produto
	 */
	private String nome;

	/**
	 * Valor do produto
	 */
	private double valor;
	/**
	 * Quantidade do produto
	 */
	private int quantidade;	
	
	
	/**
	 * Inicializa o objeto com valor padrão
	 */
	public Produto() {
		
	}	
	
	/**
	 * 
	 * @param codigo número do código do produto
	 * @param nome nome do produto
	 * @param valor valor do produto
	 * @param quantidade quantidade do produto
	 */
	public Produto(int codigo, String nome, double valor, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	
	/**
	 * Retorna o numero do codigo do produto
	 * @return numero do codigo do produto
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Altera o numero do código do produto
	 * @param codigo numero do codigo do produto
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o nome do produto
	 * @return nome do produto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do produto
	 * @param nome nome do produto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor do produto
	 * @return valor do produto
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Altera o valor do produto
	 * @param valor valor do produto
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * Retorna a quantidade do produto
	 * @return quantidade do produto
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Altera a quantidade do produto
	 * @param quantidade quantidade do produto
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Calcula o desconto em cima do valor do produto
	 * @param porcentagem porcentagem aplicada
	 * @return valor final do produto com desconto
	 */
	public double calcularDesconto(float porcentagem) {
		return valor*(1-(porcentagem)/100);
	}
		
	
	/**
	 * Retorna as informações do produto	
	 */
	public String toString() {
		return "Código; " + codigo
				+ "\nProduto: " + nome + 
				"\nQuantidade: " + quantidade +
				"\nValor: R$" + valor + "\n";
	}
		
	
	

}
