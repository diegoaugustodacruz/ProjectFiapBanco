package br.com.fiap.tds.bean;


public class Produto {
	
	private int codigo;
	
	private String nome;

	private double valor;
	
	private int quantidade;	
	
	
	
	public Produto() {
		
	}	
	

	public Produto(int codigo, String nome, double valor, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public double calcularDesconto(float porcentagem) {
		return valor*(1-(porcentagem)/100);
	}
		
	
	public double calcularDesconto(String cupom) {
		if(cupom.startsWith("FIAP")&&cupom.length()==6) {
			int desconto = Integer.parseInt(cupom.substring(4));
			return valor - valor*desconto/100;
		}
		return valor;
				
		
	}

	
	public String toString() {
		return "Código" + codigo
				+ "\nProduto: " + nome + 
				"\nQuantidade: " + quantidade +
				"\nValor: R$" + valor;
	}
		
	
	

}
