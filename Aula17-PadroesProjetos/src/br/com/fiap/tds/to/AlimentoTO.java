package br.com.fiap.tds.to;

/**
 * Classe responsavel por armazenar as informacoes que serao trafegadas entre as camadas da aplicacao ou entre outros sistemas
 * @author diego
 *
 */
public class AlimentoTO {

	private int codigo;
	
	private String nome;
	
	private double peso;
	
	public AlimentoTO() {
		
	}

	public AlimentoTO(int codigo, String nome, double peso) {
		this.codigo = codigo;
		this.nome = nome;
		this.peso = peso;
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
